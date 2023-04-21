package parking

interface ParkingSpace {
    fun parkOnSpot(vehicle: Vehicle)

    fun leaveASpot(int: Int?)

    fun hasAFreeSpot(): Boolean

    fun status()

    fun setSize(parkingSize: Int): Int

    fun getParkingSize(): Int
}