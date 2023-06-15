pipeline{
    
    agent any
    
    stages{
        
        stage("Build"){
            
            steps{
                
                echo("Build the project")
            }
            
        }
        stage("Run UTs"){
            
            steps{
                echo("Run unit tests")
            }
            
        }
        
        stage("Deploy to dev"){
            
            steps{
                echo("deploying to dev env")
            }
            
        }
        stage("Deploy to qa"){
            
            steps{
                echo("deploying to qa env")
            }
            
        }
        stage("Run regression automation test cases"){
            
            steps{
                echo("Run regression automation test cases")
            }
            
        }
        
        stage("Deploy to stage"){
            
            steps{
                echo("Deploying to stage env")
            }
            
        }
        stage("Run sanity automation test cases"){
            
            steps{
                echo("Run sanity automation test cases")
            }
            
        }
        
        stage("Deploy to prod"){
            
            steps{
                echo("Deploying to prod env")
            }
            
        }
    }
}