
def test() {
    echo "testing the application .."
}

def buildJar() {
    echo "packaging the application into jar file..."
    sh 'mvn package'
}

def buildImage() {
    echo "building docker image.."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t iankisali/demo-repo:java-app-v1.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push iankisali/demo-repo:java-app-v1.1'
    }
}

def deploy() {
    echo "deploying app.."
}

return this