pipeline {
  agent any
  environment {
    PATH = "$PATH:/usr/share/maven/bin"
  }
  stages {
    stage('GetCode') {
      steps {
        git 'https://github.com/metalgsm/progmatoz-template-oauth.git'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('SonarQube analysis') {
      //    def scannerHome = tool 'SonarScanner 4.0';
      steps {
        withSonarQubeEnv('sonarqube-6.7') {
          // If you have configured more than one global server connection, you can specify its name
          //      sh "${scannerHome}/bin/sonar-scanner"
          sh "mvn sonar:sonar"
        }
      }
    }
    stage('Docker image tag') {
        steps {
            sh "docker build -t template-img-test ."
            sh "docker tag template-img-test 10.154.20.207/dieboldcloud/template-img-test"
        }
    }
    stage('Push to Harbor') {
        steps {
            sh "docker push 10.154.20.207/dieboldcloud/template-img-test"
        }
    }
  }
}