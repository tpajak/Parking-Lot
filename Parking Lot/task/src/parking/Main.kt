package parking

import kotlin.system.exitProcess

//const val isInDebugMode: Boolean = false

fun main() {
    readCommand(Parking()).execute()
}

class SimpleCommand(private val command: () -> Unit) : Command {
    override fun execute() {
        command.invoke()
    }

}

fun readCommand(parking: Parking): Command {
    val userInput = Utils.readUserInput()
    val commandResult = CommandResult(userInput[0])

        when (commandResult.command) {
            "park" -> {
                val commandResult = CommandResult(userInput[0], userInput[1], userInput[2])
                return SimpleCommand {
                    parking.parkOnSpot(Vehicle(commandResult.regNumber, commandResult.colour))
                    readCommand(parking).execute()
                }
            }
            "leave" -> {
                val commandResult = CommandResult(userInput[0], userInput[1].toInt())
                return SimpleCommand {
                    parking.leaveASpot(commandResult.spotNumber)
                }
            }
            "exit" -> {
                return object : Command {
                    override fun execute() {
                        exitProcess(1)
                    }
                }
            }
            else -> {
                return object : Command {
                    override fun execute() {
                        println("No such command.")
                    }
                }
            }
        }
}