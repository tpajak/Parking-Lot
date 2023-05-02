package parking.conditions

import parking.Parking

object ParkingEmpty : Condition {
    override fun conditionMet(parking: Parking): Boolean {
        return parking.parkingSpace.isNullOrEmpty()
    }
}