package parking

const val isInDebugMode: Boolean = false

lateinit var command: String
lateinit var regNumber: String
lateinit var colour: String
var parkingSpotNumber: Int = 0

fun main() {
    var parking = Parking()

    readCommand()

    when (command) {
        "park" -> {
            var car = Vehicle(regNumber, colour)
            parking.park(car)

        }
        "leave" -> {
            parking.leave(parkingSpotNumber)
        }
        else -> {
            println("I don't understand your command")
        }
    }

}

fun readCommand() {
    var userInput = Utils.readUserInput()

    if (userInput[0] == "park") {
        command = userInput[0]
        regNumber = userInput[1]
        colour = userInput[2]

        if (isInDebugMode) {
            println("$command, $regNumber, $colour")
        }
    } else if (userInput[0] == "leave") {
        command = userInput[0]
        parkingSpotNumber = userInput[1].toInt()

        if (isInDebugMode) {
            println("$command, $parkingSpotNumber")
        }
    } else {
        println("No such command.")
    }


}