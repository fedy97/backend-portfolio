node {
    stage('Build') {
        checkout scm
        withMaven(maven: 'M2_HOME') {
            sh "mvn clean install"
        }
    }
}