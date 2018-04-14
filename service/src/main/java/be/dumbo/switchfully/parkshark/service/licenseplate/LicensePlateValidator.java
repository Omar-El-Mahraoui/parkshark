package be.dumbo.switchfully.parkshark.service.licenseplate;

//copied from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.licenseplate.LicensePlate;

import javax.inject.Named;

@Named
public class LicensePlateValidator {

    public boolean isValidForCreation(LicensePlate licensePlate) {
        return !isARequiredFieldEmptyOrNull(licensePlate) && licensePlate.getId() == 0;
    }

    private boolean isARequiredFieldEmptyOrNull(LicensePlate licensePlate) {
        return isNull(licensePlate) || isEmptyOrNull(licensePlate.getPlateNumber())
                || isEmptyOrNull(licensePlate.getIssuingCountry());
    }

    private boolean isNull(LicensePlate licensePlate) {
        return licensePlate == null;
    }

    private boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    public void throwInvalidStateException(LicensePlate licensePlate, String type) {
        throw new IllegalStateException("Invalid " + (licensePlate == null ? "NULL_ENTITY" : licensePlate.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (licensePlate == null ? null : licensePlate.toString()));
    }

}
