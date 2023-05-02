package parking;

class ConsoleMessageHandler : MessageHandler {

    override fun handleMessage(message: String) {
        println(message)
    }
}