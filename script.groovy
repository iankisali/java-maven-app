def build() {
    echo "building the application .."
    sh 'mvn package'
}

def buildImage() {
    echo "building docker image.."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t iankisali/demo-repo:jma-1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push iankisali/demo-repo:jma-1.2'
    }
}

def deployApp() {
    echo "deploying app.."
}

return this