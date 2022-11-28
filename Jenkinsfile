node {
    stage('Build') {
        withMaven(maven: 'M2_HOME') {
            sh "mvn clean install"
        }
    }
}