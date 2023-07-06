def job1 = new File("job1.groovy").text
def job2 = new File("job2.groovy").text


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