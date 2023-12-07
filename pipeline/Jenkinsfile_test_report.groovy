pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/java-self-testing/java-self-testing-demo-report.git'

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
