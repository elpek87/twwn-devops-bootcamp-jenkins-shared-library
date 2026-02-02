def call() {
    echo "building the docker image..."
    dir('demo-projects/module-8/java-maven-app') {
        withCredentials([usernamePassword(
                credentialsId: 'dockerhub-repo',
                passwordVariable: 'PASS',
                usernameVariable: 'USER'
        )]) {
            sh 'docker build -t elpek87/demo-app:jma-2.0 .'
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh 'docker push elpek87/demo-app:jma-2.0'
        }
    }
}