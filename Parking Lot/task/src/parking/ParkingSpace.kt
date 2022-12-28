package parking

interface ParkingSpace {
    fun parkOnSpot(vehicle: Vehicle)

    fun leaveASpot(int: Int?)

    fun hasAFreeSpot(): Boolean
}