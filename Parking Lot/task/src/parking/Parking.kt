package parking

class Parking {
    private val parkingSpace = mutableListOf<Vehicle>(
        Vehicle("dummyNumber", "dummyColour"),
        Vehicle("DB-123-12", "Orange")
    )

    fun park(vehicle: Vehicle) {
        parkingSpace.add(vehicle)
        println("${vehicle.colour} car parked in spot ${getParkingSpaceNumber(vehicle.regNumber)}.")
    }

    fun leave(parkingSpotNumber: Int) {
        if (parkingSpace.getOrNull(parkingSpotNumber) == null) {
            println("There is no car in spot ${parkingSpotNumber}.")
        } else {
            println("Spot ${parkingSpotNumber} is free.")
        }
    }

    fun getParkingSpaceNumber(regNumber: String): Int {
        val parkingSpaceNumber = parkingSpace.indexOfFirst { it.regNumber == regNumber }
        return parkingSpaceNumber
    }
}