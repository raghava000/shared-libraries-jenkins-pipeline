// vars/buildDocker.groovy
def call(String imageName) {
    echo "--- STARTING SHARED DOCKER BUILD FOR ${imageName} ---"
    sh "docker build -t ${imageName}:${env.BUILD_NUMBER} ."
    echo "--- BUILD COMPLETE ---"
}
