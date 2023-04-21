package parking

import kotlin.system.exitProcess

//const val isInDebugMode: Boolean = false

fun main() {
    var result: String? = null
//    var parkingSize: Int = 5
    val parking: Parking = Parking(ConsoleMessageHandler(), parkingSize = 0)
        var simpleCommand: Command? = null


//        var userInput = Utils.readUserInput()
//        val simpleCommand = readCommand(parking)


    do {
        simpleCommand = readCommand(parking)
        result = simpleCommand.execute()

//        if (parking.getParkingSize() == 0 && result != "exit") {
//            println("Sorry, a parking lot has not been created.")
//            //simpleCommand = readCommand(parking)
//            //result = simpleCommand.execute()
//        }

    } while (result != "exit")
    //enum or sealed class

}

class SimpleCommand(private val command: () -> String) : Command {
    override fun execute() = command.invoke()
}

fun readCommand(parking: Parking): Command {
    val userInput = Utils.readUserInput()
    val commandResult = CommandResult.Command(userInput[0])


        when (commandResult.command) {

            "create" -> {
                val commandResult = CommandResult.Create(userInput[0], userInput[1].toInt())
                return SimpleCommand {
                    parking.setSize(commandResult.parkingSize)
                    return@SimpleCommand "create"
                }
            }

            "park" -> {
                val commandResult = CommandResult.Park(userInput[0], userInput[1], userInput[2])
                return SimpleCommand {
                    parking.parkOnSpot(Vehicle(commandResult.regNumber, commandResult.colour))
                    return@SimpleCommand "park"
                }
            }

            "leave" -> {
                val commandResult = CommandResult.Leave(userInput[0], userInput[1].toInt())
                return SimpleCommand {
                    parking.leaveASpot(commandResult.spotNumber)
                    return@SimpleCommand "leave"
                }
            }

            "status" -> {
                val commandResult = CommandResult.Status(userInput[0])
                return SimpleCommand {
                    parking.status()
                    return@SimpleCommand "status"
                }
            }

            "exit" -> {
                return object : Command {
                    override fun execute(): String {
                        return "exit"
                    }
                }
            }

            else -> {
                return object : Command {
                    override fun execute(): String {
                        return "No such command."
                    }
                }
            }
        }

}

