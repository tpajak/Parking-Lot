package parking

const val isInDebugMode: Boolean = false

fun main() {

    do {
        readCommand(Parking()).execute()
    } while (readCommand(Parking()).execute().equals("exit"))

}

fun readCommand(parking: Parking): ICommand {
    var userInput = Utils.readUserInput()
    var commandResult = CommandResult(userInput)

    if (commandResult.command.equals("park")) {
        return object : ICommand {
            override fun execute() {
                parking.parkOnSpot(Vehicle(commandResult.regNumber, commandResult.colour))
            }
        }
    } else if (commandResult.command.equals("leave")) {
        return object : ICommand {
            override fun execute() {
                parking.leaveASpot(commandResult.spotNumber)
            }
        }
    } else if (commandResult.command.equals("exit")) {
        return object : ICommand {
            override fun execute() {
                println("exiting....")
            }

        }
    } else {
        return object : ICommand {
            override fun execute() {
                TODO("Not yet implemented")
            }
        }
    }
}