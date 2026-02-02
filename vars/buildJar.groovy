#!/usr/bin/env groovy

def call () {
    echo 'building the application...'
    dir('demo-projects/module-8/java-maven-app') {
        sh 'mvn -B clean package'
    }
}