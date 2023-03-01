pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
       maven 'Maven'
    }
    environment{
        
        registry = "poovithaselvaraj/docker-images98"
        registryCredential = 'd3be8a3e-9e76-4819-9daf-f921e147c318'        
    }

    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
    
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/PoovithaSelva/SimpleMavenProject'
                echo 'Pulling... ' + env.GIT_BRANCH

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat ' mvn -f pom.xml clean install'  
            
            }

            
        }
         stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
       stage('Deploy Image') {
      steps{
         script {
            withDockerRegistry([ credentialsId: "dockerhub", url: "" ])  {
            dockerImage.push()
          }
        }
      }
           
       }
    }
post
{
success{
script{
switch(env.BRANCH_NAME)
{
   case['master']:
     echo " success $JOB_NAME ,env.BRANCH_NAME"
     break
}
build job : JOB_NAME.replace('/master/' , '/main/')
echo " triggered main"

}
script{
echo "final step"}}
}}