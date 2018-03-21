pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''echo \'Building sample\'
mvn clean install'''
      }
    }
  }
}