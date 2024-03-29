def job1 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job1.groovy")
def job2 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job2.groovy")
def job3 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job3.groovy")
def job4 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job4-pipeline.groovy")
def job5 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job5.groovy")
def job6 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job6.groovy")
def job7 = readFileFromWorkspace("${WORKSPACE}/JenkinsFile/Conda_env/Jenkinsfile")
def job8 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job8.groovy")

def jobPrefix = 'test-112'

job('job1') {
      job1
}


job('job2') {
      job2
}

pipelineJob('job3'){
    job3
}

job('job5'){
    job5
}



job4

job('job6') {
  description('job6')
  steps {
    shell(job6)
  }
}


pipelineJob('job7') {
  definition {
    cps {
      script(job7)
    }
  }
}

pipelineJob('job8') {
    job8
}

pipelineJob('job9') {
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
}

pipelineJob('job10') {
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
      scriptPath("job10/JenkinsFile/Conda_env/Jenkinsfile")
    }
  }
}

pipelineJob('job11') {
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
      scriptPath("JenkinsFile/Conda_env/Jenkinsfile")
    }
  }
}

pipelineJob("${jobPrefix}-job1-defination-test") {
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
      scriptPath("JenkinsFile/Conda_env/Jenkinsfile")
    }
  }
}

// load("${WORKSPACE}/dsl/src/job1.groovy")
// load("${WORKSPACE}/dsl/src/job2.groovy")