
def test() {
    echo "testing the application .."
}

def buildImage() {
    echo "building docker image.."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t iankisali/demo-repo:jma-1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push iankisali/demo-repo:java-app-v1.1'
    }
}

def deploy() {
    echo "deploying app.."
}

return this