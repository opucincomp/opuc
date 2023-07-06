pipelineJob('job4-pipeline'){
definition {
    cps {
        script(readFileFromWorkspace("${WORKSPACE}/JenkinsFile/Conda_env/Jenkinsfile"))
        sandbox() 
    }
}
}