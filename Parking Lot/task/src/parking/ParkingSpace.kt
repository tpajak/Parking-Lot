package parking

interface ParkingSpace {
    fun parkOnSpot(vehicle: Vehicle)

    fun leaveASpot(int: Int?)

    fun hasAFreeSpot(): Boolean

    fun status()

    fun registrationByColour(colour: String)

    fun spotByColour(colour: String)

    fun spotByRegistration(registrationNumber: String)

    fun setSize(parkingSize: Int): Int

    fun getParkingSize(): Int
}