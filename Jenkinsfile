node {
    stage('Build') {
        withMaven {
            maven: 'maven-3.8.6',
            sh "mvn clean install"
        }
    }
}