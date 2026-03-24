// vars/logInfo.groovy
def call(String message) {
    echo "-------------------------------------------"
    echo "[DEVOPS-FACTORY] : ${message.toUpperCase()}"
    echo "-------------------------------------------"
}
