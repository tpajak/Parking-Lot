package parking.conditions

import parking.Parking

object ParkingCreated: Condition {
    override fun conditionMet(parking: Parking): Boolean {
        return parking.parkingStatus == Parking.ParkingStatus.CREATED
    }
}