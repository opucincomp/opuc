definition {
    cps {
        script(readFileFromWorkspace("${WORKSPACE}/Conda_env/JenkinsFile"))
        sandbox() 
    }
}
