pipeline {
    agent {
        node{
            label 'jenkins-agent'
        }
    }
    triggers {
        pollSCM 'H/5 * * * *'
    }
    tools {
        jdk 'jdk17'
        maven 'maven-3.8.7'
    }
    stages {
        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
//         stage("Quality Gate") {
//             steps {
//                 timeout(time: 10, unit: 'MINUTES') {
//                     script{
//                         def qualitygate = waitForQualityGate()
//                         if (qualitygate.status != "OK") {
//                             error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
//                         }
//                     }
//                 }
//             }
//         }
    }
}
