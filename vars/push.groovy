def call(String credId, String imageName, String tag){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
                
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag ${imageName}:${tag} ${env.dockerHubUser}/${imageName}:{tag}"
                sh "docker push ${env.dockerHubUser}/${imageName}:{tag}"
            
                }  
}
