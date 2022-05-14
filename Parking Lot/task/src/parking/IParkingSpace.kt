package parking

interface IParkingSpace {
    fun parkOnSpot(vehicle: Vehicle)

    fun leaveASpot(int: Int?)
}