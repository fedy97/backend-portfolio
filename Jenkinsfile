node {
  stage ('Build') {
    git url: 'https://github.com/fedy97/backend-portfolio'
    withMaven {
      sh "mvn clean install"
    }
  }
}