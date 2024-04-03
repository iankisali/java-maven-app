def build() {
    echo "building the application .."
}

def test() {
    echo "testing the application .."
}

def buildImage() {
    echo "building docker image.."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t iankisali/demo-repo:jma-1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push iankisali/demo-repo:jma-1.2'
    }
}

def deploy() {
    echo "deploying app.."
    echo "deploying app version ${params.VERSION}."
}

return this