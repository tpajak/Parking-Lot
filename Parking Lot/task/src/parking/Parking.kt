package parking

class Parking(
    private val handler: IMessageHandler = ConsoleMessageHandler(),
) : IParkingSpace {

    private val parkingSpace = mutableListOf<Vehicle>(
        // Project initial assumptions
        // 1. First slot is already occupied
        // 2. Second slot is free
        Vehicle("dummyNumber", "dummyColour"),
        Vehicle("DB-123-12", "Orange")
    )

    override fun parkOnSpot(vehicle: Vehicle) {
        parkingSpace.add(vehicle)
        handler.handleMessage("${vehicle.colour} car parked in spot ${parkingSpace.size - 1}.")
    }

    override fun leaveASpot(int: Int?) {
        if (parkingSpace.getOrNull(int!!) == null) {
            handler.handleMessage("There is no car in spot ${int}.")
        } else {
            handler.handleMessage("Spot ${int} is free.")
        }
    }
}