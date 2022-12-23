package parking

data class ParkingEvent(
    var _registrationNumber: String,
    var _colour: String
) {
    val registrationNumber = _registrationNumber
        get(): String {
            return if (field != "") "" else field
        }

    val colour: String
        get() = _colour
}