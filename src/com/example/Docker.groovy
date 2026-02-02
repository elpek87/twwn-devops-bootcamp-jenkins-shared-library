#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage (String imageName) {
        script.echo "building the docker image..."
        script.dir('demo-projects/module-8/java-maven-app') {
            script.withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                script.sh "docker build -t $imageName ."
                script.sh "echo '${script.$PASS} | docker login -u '${script.USER} --password-stdin"
                script.sh "docker push $imageName"
            }
        }
    }
}