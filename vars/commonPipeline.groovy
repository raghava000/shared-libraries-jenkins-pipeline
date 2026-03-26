def call(Map config = [:]) {
    pipeline {
        agent {
            docker {
                image 'python:3.9-slim'
                // Ensure this path exists on your GCP VM!
                // Use the NAME of the volume, not the PATH
                args '-v python_api_practice:/data'
            }
        }

        environment {
            PROJECT_ID = "${config.project_id}"
            APP_NAME   = "${config.app_name}"
        }

        stages {
            stage('Initialization') {
                steps {
                    script {
                        // Use env. prefix for environment variables inside script blocks
                        echo "--- Starting Pipeline for ${env.APP_NAME} ---"
                    }
                }
            }
            stage('Quality & Build') {
                parallel {
                    stage('Run Tests') {
                        steps {
                            sh 'python3 --version'
                        }
                    }
                    stage('Build') {
                        steps {
                            sh 'python3 --version'
                        }
                    }
                }
            }
        }
    } // <--- THIS is where the pipeline ends
}
