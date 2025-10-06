// Jenkins pipeline script
pipeline {
    
    // any jenkins agent can pick up and execute this pipeline
    agent any 

    // configure the tools needed for this pipeline
    // we need jdk and maven for this pipeline
    tools {
        jdk 'JDK-21'
        maven 'maven'
    }

    // define the stages of the pipeline
    stages {

        // checkout the source code from git repository
        stage('Checkout') {
            steps {
                // git command to checkout the code
                git branch: 'master', url: 'https://github.com/ashish-panicker/java-github-action-demo.git'
            }
        }

        // build the maven project
        stage('Build') {
            steps {
                // maven command to clean and package the project
                bat 'mvn clean install -DskipTests'
            }
        }

        // run the test cases
        stage('Test') {
            steps {
                // maven command to run the test cases
                bat 'mvn test'
            }
        }

        // package the application
        stage('Package') {
            steps {
                // maven command to package the application
                bat 'mvn package'
            }
        }
    } // end of stages

    post {
        // success
        success {
            echo 'Pipeline completed successfully!'
        }
        // failure
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }   
    }// end of post

}