package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;

import javax.inject.Named;
//copied from order solution switchfully

@Named
public class DivisionValidator {

    private boolean isARequiredFieldEmptyOrNull(Division division) {
        return isNull(division) || isEmptyOrNull(division.getOriginalName())
                || isEmptyOrNull(division.getName())
                || isEmptyOrNull(division.getDirector());
    }

    private boolean isNull(Division division) {
        return division == null;
    }

    private boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    public boolean isValidForCreation(Division division) {
        return !isARequiredFieldEmptyOrNull(division);
    }

    public void throwInvalidStateException(Division division, String type) {
        throw new IllegalStateException("Invalid " + (division == null ? "NULL_ENTITY" : division.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (division  == null ? null : division.toString()));
    }

}
