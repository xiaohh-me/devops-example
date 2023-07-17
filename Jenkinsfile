pipeline {
    agent any

    stages {
        stage('Checkout From Git') {
            steps {
                checkout scmGit(branches: [[name: '${tag}']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:xiaohh-me/devops-example.git']])
            }
        }
        stage('Build By Maven') {
            steps {
                sh '''mvn clean package -Dmaven.test.skip
                mkdir docker/java
                mv target/devops-example.jar docker/java
                mvn clean'''
            }
        }
    }
}
