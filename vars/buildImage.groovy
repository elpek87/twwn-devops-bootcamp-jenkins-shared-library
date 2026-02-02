def call(String imageName) {
    echo "building the docker image..."
    dir('demo-projects/module-8/java-maven-app') {
        withCredentials([usernamePassword(
                credentialsId: 'dockerhub-repo',
                passwordVariable: 'PASS',
                usernameVariable: 'USER'
        )]) {
            sh "docker build -t $imageName ."
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh "docker push $imageName"
        }
    }
}