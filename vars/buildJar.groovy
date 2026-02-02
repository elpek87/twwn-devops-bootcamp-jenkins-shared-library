#!/usr/bin/env groovy

def call () {
    echo "building the application for branch $GIT_BRANCH"
    dir('demo-projects/module-8/java-maven-app') {
        sh 'mvn -B clean package'
    }
}