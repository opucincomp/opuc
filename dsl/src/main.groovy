def job1 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job1.groovy").text
def job2 = readFileFromWorkspace("${WORKSPACE}/dsl/src/job2.groovy").text


job('job1') {
  definition {
    cps {
      script(job1)
    }
  }
}


job('job2') {
  definition {
    cps {
      script(job2)
    }
  }
}

// load("${WORKSPACE}/dsl/src/job1.groovy")
// load("${WORKSPACE}/dsl/src/job2.groovy")