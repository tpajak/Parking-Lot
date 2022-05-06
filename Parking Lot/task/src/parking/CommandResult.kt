package parking

class CommandResult(val command: String) {
    var regNumber: String? = null
    var colour: String? = null
    var spotNumber: Int? = null

    constructor(command: String, spotNumber: Int) : this(command) {
        this.spotNumber = spotNumber
    }

    constructor(command: String, regNumber: String, colour: String) : this(command) {
        this.regNumber = regNumber
        this.colour = colour
    }
}