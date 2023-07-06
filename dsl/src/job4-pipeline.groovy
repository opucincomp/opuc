definition {
    cps {
        script(readFileFromWorkspace("${WORKSPACE}/JenkinsFile/Conda_env/JenkinsFile"))
        sandbox() 
    }
}
