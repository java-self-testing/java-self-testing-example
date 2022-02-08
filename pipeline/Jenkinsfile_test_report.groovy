pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git 'https://gitlab.com/nlin101/java-self-testing-demo-all.git'

                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
