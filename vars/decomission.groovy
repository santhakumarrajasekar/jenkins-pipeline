#!/usr/bin/env groovy

def call(String name) {
    echo "Decomissioning ${name}."
    switch(name) {
	case "App1":
	    sh "docker rm -f docker_app1_1"
	    sh "docker rmi -f \$(docker images 'docker_app1_1' -q)"
	    break
	case "App2":
	    sh "docker rm -f docker_app2_1"
	    sh "docker rmi -f \$(docker images 'docker_app2_1' -q)"
	    break
	case "Both":
	    sh "docker rm -f \$(docker ps -a -f 'name=docker_app' -q)"
            sh "docker rmi -f \$(docker images 'docker_app*' -q)"
	    break
	case "None":
	    echo "Nothing to decomission"
	    break
    }
}
