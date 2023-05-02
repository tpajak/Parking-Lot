package parking.conditions

import parking.Parking

interface Condition {
    fun conditionMet(parking: Parking) : Boolean
}