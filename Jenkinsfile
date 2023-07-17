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
        stage('Build By Docker') {
            steps {
                sh '''cd docker
                docker build -t registry.cn-hangzhou.aliyuncs.com/xiaohh-test/devops-example:${tag} .
                rm -rf java'''
            }
        }
        stage('Push Docker Image To Repository') {
            steps {
                sh '''docker push registry.cn-hangzhou.aliyuncs.com/xiaohh-test/devops-example:${tag}
                docker rmi registry.cn-hangzhou.aliyuncs.com/xiaohh-test/devops-example:${tag}'''
            }
        }
        stage('Exec On Kubernetes') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'k8s-master', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'kubectl set image deployment devops-example devops-example=registry.cn-hangzhou.aliyuncs.com/xiaohh-test/devops-example:${tag} --record', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
