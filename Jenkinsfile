node{
    
    stage('git checkout'){
    git 'https://github.com/StaragileDevops/seleniumTest'
    }
     
    
    stage('Running selenium'){
    sh 'xvfb-run mvn compile exec:java -Dexec.mainClass="com.selenium.Insurance.assignment.selenium.insurance.App"'
    } 
    
    
    
}
