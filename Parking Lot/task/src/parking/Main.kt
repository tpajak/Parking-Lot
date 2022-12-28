package parking

import kotlin.system.exitProcess

//const val isInDebugMode: Boolean = false

fun main() {
        var result: String? = null
        val parking: Parking = Parking()
    do {
        val simpleCommand = readCommand(parking)

        result = simpleCommand.execute()
    } while (result != "exit")
    //enum or sealed class
}

class SimpleCommand(private val command: () -> String) : Command {
    override fun execute() = command.invoke()
}


fun readCommand(parking: Parking): Command {
    val userInput = Utils.readUserInput()
    val commandResult = CommandResult(userInput[0])

    when (commandResult.command) {
        "park" -> {
            val commandResult = CommandResult(userInput[0], userInput[1], userInput[2])
            return SimpleCommand {
                parking.parkOnSpot(Vehicle(commandResult.regNumber, commandResult.colour))
                return@SimpleCommand "park"
            }
        }

        "leave" -> {
            val commandResult = CommandResult(userInput[0], userInput[1].toInt())
            return SimpleCommand {
                parking.leaveASpot(commandResult.spotNumber)
                return@SimpleCommand "leave"
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