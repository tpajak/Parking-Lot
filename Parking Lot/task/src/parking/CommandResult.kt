package parking

class CommandResult(command: List<String>) {
    val command: String = command[0]
    var regNumber: String? = null
    var colour: String? = null
    var spotNumber: Int? = null

    init {
        when {
            command[0].equals("leave") -> {
                spotNumber = command[1].toInt()
            }
            command[0].equals("park") -> {
                regNumber = command[1]
                colour = command[2]
            }
        }
    }
}