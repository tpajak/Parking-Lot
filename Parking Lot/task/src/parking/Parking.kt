package parking

import java.util.*

class Parking(
    private val handler: MessageHandler = ConsoleMessageHandler(),
//    private val initialState: List<Vehicle> = emptyList()
) : ParkingSpace {

    //    private val parkingSpace = mutableListOf<Vehicle>(
//        // Project initial assumptions
//        // 1. First slot is already occupied
//        // 2. Second slot is free
////        Vehicle("dummyNumber", "dummyColour"),
////        Vehicle("DB-123-12", "Orange")
//    )
    private val parkingSize: Int = 20
    private val parkingSpace: Array<Vehicle?> = arrayOfNulls(parkingSize)

    override fun parkOnSpot(vehicle: Vehicle) {
        for (parkingLot in parkingSpace.indices) {
            if (parkingSpace[parkingLot] === null) {
                parkingSpace[parkingLot] = vehicle
                handler.handleMessage("${vehicle.colour} car parked in spot ${parkingLot + 1}.")
                //println(parkingSpace.contentToString())
                break
            }
            if (!hasAFreeSpot()) {
                handler.handleMessage("Sorry, the parking lot is full.")
                break
            }
        }

    }

    override fun leaveASpot(int: Int?) {
        if (parkingSpace.getOrNull(int!! -1) == null) {
                handler.handleMessage("There is no car in spot ${int}.")
            } else {
                parkingSpace[int-1] = null
                handler.handleMessage("Spot $int is free.")
            }
    }

    override fun hasAFreeSpot(): Boolean {
        var count = 0
        for (parkingLot in parkingSpace.indices) {
            if (parkingSpace[parkingLot] === null) {
                count++
            }
        }
        return count > 0
    }

}