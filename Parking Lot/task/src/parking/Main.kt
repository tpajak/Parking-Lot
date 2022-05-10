package parking

const val isInDebugMode: Boolean = false

fun main() {

    readCommand(Parking()).execute()

}

fun readCommand(parking: Parking): ICommand {
    var userInput = Utils.readUserInput()
    var commandResult = CommandResult(userInput[0])

    if (commandResult.command.equals("park")) {
        var commandResult = CommandResult(userInput[0], userInput[1], userInput[2])
        return object : ICommand {
            override fun execute() {
                parking.parkOnSpot(Vehicle(commandResult.regNumber, commandResult.colour))
            }
        }
    } else if (commandResult.command.equals("leave")) {
        var commandResult = CommandResult(userInput[0], userInput[1].toInt())
        return object : ICommand {
            override fun execute() {
                parking.leaveASpot(commandResult.spotNumber)
            }
        }
    } else {
        return object : ICommand {
            override fun execute() {
                println("No such command.")
            }
        }
    }

}