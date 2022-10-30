pipeline {
    // 声明 agent none 意味着下面每个阶段都需要定义 agent
    agent none
    options {
        disableConcurrentBuilds()
    }
    stages {
        // 运行代码风格检查
        stage('Checkstyle') {
            agent {
                label 'slave'
            }
            steps {
                // 在同目录中定义一个 ci 的 shell 运行自己的检查机制。sh 命令可以执行 shell 脚本
                // sh './ci checkstyle'
                echo 'run checkstyle'
            }
        }
        // 运行单元测试
        stage('Unit Test') {
            agent {
                label "slave"
            }
            steps {
                script {
                    // sh './ci unitTest'
                    echo 'run unitTest'
                }
            }
        }
        // 运行构建脚本，发布制品到仓库
        stage('Build Image') {
            agent {
                label 'slave'
            }
            steps {
                // sh './ci build'
                echo "image built"
            }
        }
        // 部署到开发环境
        stage('Deploy DEV') {
            agent {
                label 'slave'
            }
            environment {
                ENV = 'dev'
            }
            steps {
                sh 'env'
                // sh './ci deploy'
                echo "image deployed"
            }
        }
        // 运行 API 测试
        stage('API Test') {
            agent {
                label "slave"
            }
            steps {
                //  sh './ci apiTest'
                echo 'run apiTest'
            }
        }
        // 部署到测试环境
        stage('Deploy QA') {
            agent {
                label 'slave'
            }
            environment {
                ENV = 'qa'
            }
            steps {
                // 如果构建一直无人处理，900s 后自动关闭
                timeout(time: 900, unit: 'SECONDS') {
                    // 需要测试人员确认才能部署成功
                    input(message: 'deploy to QA?')
                }
                sh 'env'
                //  sh './ci deploy'
                echo "image deployed"
            }
        }
        // 部署到预发环境
        stage('Deploy UAT') {
            agent {
                label 'slave'
            }
            environment {
                ENV = 'uat'
            }
            steps {
                timeout(time: 900, unit: 'SECONDS') {
                    // 约束只有在名单中人能部署到预发环境
                    input(message: 'deploy to UAT?', submitter: 'zhangsan,lisi')
                }
                sh 'env'
                //  sh './ci deploy'
                echo "image deployed"
            }
        }
        // 部署到生产环境
        stage('Deploy PROD') {
            agent {
                label 'slave'
            }
            environment {
                ENV = 'prod'
            }
            input {
                message 'deploy to PROD?'
                submitter 'zhangsan'
                parameters {
                    // 约束只有在名单中人能部署到预发环境，并且需要输入一段确认文本
                    string(name: 'PASSWORD', defaultValue: '', description: 'Say the words...')
                }
            }
            steps {
                script {
                    if (PASSWORD != "PROD")
                        error "SORRY, YOU DON'T HAVE THE PASSWORD!"
                }
                sh 'env'
                //  sh "./ci deploy"
                echo "image deployed"
            }
        }
    }
}
