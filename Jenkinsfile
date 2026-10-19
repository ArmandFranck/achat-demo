pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKERHUB_USER = 'franckarmand225'
        IMAGE_TAG      = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Récupération du code') {
            steps {
                checkout scm
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn -B -f backend/pom.xml clean package'
            }
        }

        stage('Build des images Docker') {
            steps {
                sh 'docker build -t $DOCKERHUB_USER/achat-backend:$IMAGE_TAG -t $DOCKERHUB_USER/achat-backend:latest backend'
                sh 'docker build -t $DOCKERHUB_USER/achat-frontend:$IMAGE_TAG -t $DOCKERHUB_USER/achat-frontend:latest frontend'
            }
        }

        stage('Push sur Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                                  usernameVariable: 'DH_USER',
                                                  passwordVariable: 'DH_TOKEN')]) {
                    sh 'echo "$DH_TOKEN" | docker login -u "$DH_USER" --password-stdin'
                    sh 'docker push $DOCKERHUB_USER/achat-backend:$IMAGE_TAG'
                    sh 'docker push $DOCKERHUB_USER/achat-backend:latest'
                    sh 'docker push $DOCKERHUB_USER/achat-frontend:$IMAGE_TAG'
                    sh 'docker push $DOCKERHUB_USER/achat-frontend:latest'
                    sh 'docker logout'
                }
            }
        }

        stage('Déploiement avec Docker Compose') {
            steps {
                sh 'docker compose up -d'
                sh 'docker compose ps'
            }
        }
    }
}
