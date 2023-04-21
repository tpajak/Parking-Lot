package parking

class Parking(
    private val handler: MessageHandler,
    private var parkingSize: Int,
) : ParkingSpace {

    private var parkingSpace: Array<Vehicle?> = arrayOfNulls(parkingSize)

    override fun parkOnSpot(vehicle: Vehicle) {
        if (parkingSize == 0) {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        } else {
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

    }

    override fun leaveASpot(int: Int?) {
        if (parkingSize == 0) {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        } else {
            if (parkingSpace.getOrNull(int!! - 1) == null) {
                handler.handleMessage("There is no car in spot ${int}.")
            } else {
                parkingSpace[int - 1] = null
                handler.handleMessage("Spot $int is free.")
            }
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

    override fun status() {
        if (parkingSize == 0) {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        } else {
            var isArrayEmpty: Boolean = true

            for (parkingLot in parkingSpace.indices) {
                if (parkingSpace[parkingLot] != null) {
                    println("${parkingLot + 1} ${parkingSpace[parkingLot]?.regNumber} ${parkingSpace[parkingLot]?.colour}")
                }
                if (parkingSpace[parkingLot] != null) {
                    isArrayEmpty = false
                }
            }
            if (isArrayEmpty) {
                println("Parking lot is empty.")
            }
        }
    }

    override fun setSize(parkingSize: Int): Int {
        this.parkingSize = parkingSize
        parkingSpace = arrayOfNulls(parkingSize)
        println("Created a parking lot with ${parkingSize} spots.")
        return this.parkingSize
    }

    override fun getParkingSize(): Int {
        return this.parkingSize
    }

}