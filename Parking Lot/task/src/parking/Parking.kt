package parking

import parking.conditions.ParkingCreated
import parking.conditions.ParkingEmpty

class Parking(
    private val handler: MessageHandler,
    private var parkingSize: Int,
) : ParkingSpace {

    var parkingSpace: Array<Vehicle?> = arrayOfNulls(parkingSize)
        private set
    var parkingStatus = ParkingStatus.UNKNOWN
        private set //private setter for parkingStatus

    override fun parkOnSpot(vehicle: Vehicle) {
        if (ParkingCreated.conditionMet(this)) {
            for (parkingLot in parkingSpace.indices) {
                if (parkingSpace[parkingLot] === null) {
                    parkingSpace[parkingLot] = vehicle
                    handler.handleMessage("${vehicle.colour} car parked in spot ${parkingLot + 1}.")
                    break
                }
                if (!hasAFreeSpot()) {
                    handler.handleMessage("Sorry, the parking lot is full.")
                    break
                }
            }
        } else {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        }
    }

    override fun leaveASpot(int: Int?) {
        if (ParkingCreated.conditionMet(this)) {
            if (parkingSpace.getOrNull(int!! - 1) == null) {
                handler.handleMessage("There is no car in spot ${int}.")
            } else {
                parkingSpace[int - 1] = null
                handler.handleMessage("Spot $int is free.")
            }
        } else {
            handler.handleMessage("Sorry, a parking lot has not been created.")
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
        if (ParkingCreated.conditionMet(this)) {
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
        } else {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        }
    }

    override fun registrationByColour(colour: String) {
        if (ParkingCreated.conditionMet(this)) {
            var elementFound: Boolean = false
            val listOfCars = mutableListOf<String>()
            val separator = ", "
            for (parkingLot in parkingSpace.indices) {
                if (parkingSpace[parkingLot] != null) {
                    if (parkingSpace[parkingLot]?.colour!!.uppercase() == colour.uppercase()) {
                        listOfCars.add(parkingSpace[parkingLot]?.regNumber.toString())
                        elementFound = true
                    }
                }
            }
            if (elementFound) {
                println(listOfCars.joinToString(separator))
                elementFound = false
            } else {
                handler.handleMessage("No cars with color ${colour.uppercase()} were found.")
                elementFound = false
            }

        } else {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        }
    }

    override fun spotByColour(colour: String) {
        if (ParkingCreated.conditionMet(this)) {
            var elementFound: Boolean = false
            val listOfSpots = mutableListOf<Int>()
            val separator = ", "
            for (parkingLot in parkingSpace.indices) {
                if (parkingSpace[parkingLot] != null) {
                    if (parkingSpace[parkingLot]?.colour!!.lowercase() == colour.lowercase()) {
                        listOfSpots.add(parkingLot + 1)
                        elementFound = true
                    }
                }
            }
            if (elementFound) {
                println(listOfSpots.joinToString(separator))
                elementFound = false
            } else {
                handler.handleMessage("No cars with color ${colour.uppercase()} were found.")
                elementFound = false
            }

        } else {
            handler.handleMessage("Sorry, a parking lot has not been created.")
        }
    }


        override fun spotByRegistration(registrationNumber: String) {
            if (ParkingCreated.conditionMet(this)) {
                var nothingFound: Boolean = false
                val listOfSpots = mutableListOf<Int>()
                val separator = ", "
                for (parkingLot in parkingSpace.indices) {
                    if (parkingSpace[parkingLot] != null) {
                        if (parkingSpace[parkingLot]?.regNumber!!.lowercase() == registrationNumber.lowercase()) {
                            listOfSpots.add(parkingLot + 1)
                            nothingFound = true
                        }
                    }
                }
                if (nothingFound) {
                    println(listOfSpots.joinToString(separator))
                    nothingFound = false
                } else {
                    handler.handleMessage("No cars with registration number ${registrationNumber.uppercase()} were found.")
                    nothingFound = false
                }
            } else {
                handler.handleMessage("Sorry, a parking lot has not been created.")
            }
        }

        override fun setSize(parkingSize: Int): Int {
            this.parkingSize = parkingSize
            parkingSpace = arrayOfNulls(parkingSize)
            println("Created a parking lot with ${parkingSize} spots.")
            parkingStatus = ParkingStatus.CREATED
            return this.parkingSize
        }

        override fun getParkingSize(): Int {
            return this.parkingSize
        }

        enum class ParkingStatus {
            CREATED,
            UNKNOWN
        }

    }