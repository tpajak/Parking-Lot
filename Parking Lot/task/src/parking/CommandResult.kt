package parking


sealed class CommandResult(var command: String) {
    class Command(command: String) : CommandResult(command = command)
    class Create(command: String, var parkingSize: Int) : CommandResult(command = command)
    class Park(command: String, var regNumber: String, var colour: String) : CommandResult(command = command)
    class Leave(command: String, var spotNumber: Int) : CommandResult(command = command)
    class Status(command: String) : CommandResult(command = command)
}

/*
class CommandResult(val command: String) {
    var regNumber: String? = null
    var colour: String? = null
    var spotNumber: Int? = null
    var parkingSize: Int? = null

    constructor(command: String, spotNumber: Int) : this(command) {
        this.spotNumber = spotNumber
    }

    constructor(command: String, regNumber: String, colour: String) : this(command) {
        this.regNumber = regNumber
        this.colour = colour
    }

    constructor(command: String, parkingSize: Int) : this(command) {
        this.parkingSize = parkingSize
    }

}
 */