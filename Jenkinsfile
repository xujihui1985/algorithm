pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        parallel(
          "build": {
            echo 'starbuild'
            echo 'bbbb'
            echo '${gitlabrepo}'
            
          },
          "build2": {
            echo 'build2'
            
          }
        )
      }
    }
    stage('ci') {
      steps {
        echo 'run ci'
      }
    }
  }
}