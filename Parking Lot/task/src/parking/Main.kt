package parking

const val isInDebugMode: Boolean = true

fun main() {
    val (command, regNumber, colour) = Utils.readUserInput()

    if (isInDebugMode) {
        println("$command, $regNumber, $colour")
    }

}

