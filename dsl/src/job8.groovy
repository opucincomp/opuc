  definition {
    cpsScm {
      scm {
        git {
          remote {
            url("https://github.com/opucincomp/opuc.git")
            credentials("githubcreds")
          }
          branch('*/master')
        }
      }
      scriptPath("${WORKSPACE}/JenkinsFile/Conda_env/Jenkinsfile")
    }
  }