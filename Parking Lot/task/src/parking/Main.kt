package parking

const val isInDebugMode: Boolean = false

fun main() {

    readCommand(Parking()).execute()

}

fun readCommand(parking: Parking): ICommand {
    var userInput = Utils.readUserInput()

    if (userInput[0] == "park") {
        if (isInDebugMode) {
            println("${userInput[0]}, ${userInput[1]}, ${userInput[2]}")
        }
        return object : ICommand {
            override fun execute() {
                parking.parkOnSpot(Vehicle(userInput[1], userInput[2]))
            }
        }
    } else if (userInput[0] == "leave") {
        if (isInDebugMode) {
            println("${userInput[0]}, ${userInput[1]}")
        }
        return object : ICommand {
            override fun execute() {
                parking.leaveASpot(userInput[1].toInt())
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