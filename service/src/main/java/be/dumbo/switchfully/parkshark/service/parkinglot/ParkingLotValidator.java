/*
package be.dumbo.switchfully.parkshark.service.parkinglot;

//copied from order solution switchfully
// change this with javax validation http://www.baeldung.com/javax-validation

import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot;

import javax.inject.Named;

@Named
public class ParkingLotValidator {

    private boolean requiredFieldIsNull(ParkingLot parkingLot) {
        return isNull(parkingLot)
                || isNull(parkingLot.getName())
                || isNull(parkingLot.getDivision())
                || isNull(parkingLot.getCapacity())
                || isNull(parkingLot.getPricePerHourInEuro())
                || isNull(parkingLot.getContactPerson())
                || isNull(parkingLot.getAddress())
                || isNull(parkingLot.getBuildingType());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    public boolean isValidForCreation(ParkingLot parkingLot) {
        return !requiredFieldIsNull(parkingLot) && idIsNull(parkingLot);
    }

    private boolean idIsNull(ParkingLot parkingLot) {
        return parkingLot.getId() == null;
    }

    public void throwInvalidStateException(ParkingLot parkingLot, String type) {
        throw new IllegalStateException("Invalid " + (parkingLot == null ? "NULL_ENTITY" : parkingLot.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (parkingLot  == null ? null : parkingLot.toString()));
    }

}
*/
