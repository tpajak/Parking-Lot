package parking

class Parking() {
    private val parkingSpace = mutableListOf<Vehicle>()
    private val vehicle: Vehicle
        get() {
            TODO()
        }


    fun park(vehicle: Vehicle){
        println("${vehicle.colour} car parked in spot ${parkingSpace}.")
    }

    fun leave(parkingSpace: Int){
        println("Spot ${parkingSpace} is free.")
        println("There is no car in spot ${parkingSpace}.")
    }

    val integers = intArrayOf(1, 2, 3, 4)
}