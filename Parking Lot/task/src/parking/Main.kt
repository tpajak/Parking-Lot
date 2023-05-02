package parking

//const val isInDebugMode: Boolean = false

fun main() {
    var result: String? = null
    val parking: Parking = Parking(ConsoleMessageHandler(), parkingSize = 0)
    var simpleCommand: Command? = null

    do {
        simpleCommand = readCommand(parking)
        result = simpleCommand.execute()

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

            "reg_by_color" -> {
                val commandResult = CommandResult.RegistrationsByColour(userInput[0], userInput[1])
                return SimpleCommand {
                    parking.registrationByColour(commandResult.colour)
                    return@SimpleCommand "reg_by_color"
                }
            }

            "spot_by_color" -> {
                val commandResult = CommandResult.SportByColour(userInput[0], userInput[1])
                return SimpleCommand {
                    parking.spotByColour(commandResult.colour)
                    return@SimpleCommand "spot_by_color"
                }
            }

            "spot_by_reg" -> {
                val commandResult = CommandResult.SportByRegistration(userInput[0], userInput[1])
                return SimpleCommand {
                    parking.spotByRegistration(commandResult.regNumber)
                    return@SimpleCommand "spot_by_reg"
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

