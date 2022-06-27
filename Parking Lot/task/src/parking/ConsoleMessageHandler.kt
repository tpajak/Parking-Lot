package parking;

class ConsoleMessageHandler : IMessageHandler {

    override fun handleMessage(message: String) {
        println(message)
    }
}

