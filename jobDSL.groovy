pipeline {
    agent any
 
    stages {
        stage('Create Jobs') {
            steps {
                script {
                    // Loop through jobs 1 to 100
                    for (int i = 1; i <= 100; i++) {
                        // Define job name
                        def jobName = "Test-${i}"
 
                        // Define folder structure based on job number
                        def folderStructure = ""
                        if (i == 1) {
                            folderStructure = "01-automerges"
                        } else if (i == 2) {
                            folderStructure = "subfolder/01-automerges"
                        } else if (i == 3) {
                            folderStructure = "subfolder/subfolder-level2/automerges"
                        } else {
                            folderStructure = "01-automerges"
                        }
 
                        // Create the job
                        jobDsl(script: """
                            folder('${jobName}') {
                                folder('${folderStructure}') {
                                    // Add job configuration here
                                    // You can customize the job settings inside this block
                                    // Example: job('MyJob') { ... }
                                }
                            }
                        """)
                    }
                }
            }
        }
    }
}
