package parking


sealed class CommandResult(var command: String) {
    class Command(command: String) : CommandResult(command = command)
    class Create(command: String, var parkingSize: Int) : CommandResult(command = command)
    class Park(command: String, var regNumber: String, var colour: String) : CommandResult(command = command)
    class Leave(command: String, var spotNumber: Int) : CommandResult(command = command)
    class Status(command: String) : CommandResult(command = command)
    class RegistrationsByColour(command: String, var colour: String) : CommandResult(command = command)
    class SportByColour(command: String, var colour: String) : CommandResult(command = command)
    class SportByRegistration(command: String, var regNumber: String) : CommandResult(command = command)
}