package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;
//copied from order solution switchfully

@Named
public class DivisionValidator {

    private boolean requiredFieldIsEmptyOrNull(Division division) {
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

    public boolean isValidForCreation(Division division, List<Division> divisions) {
        return !requiredFieldIsEmptyOrNull(division) && hasValidParentId(division, divisions);
    }

    private boolean hasValidParentId(Division division, List<Division> divisions) {
        return division.getParentDivision() == null
                || divisions.stream()
                        .map(division1 -> division1.getId())
                        .collect(Collectors.toList())
                        .contains(division.getParentDivision());
    }

    public void throwInvalidStateException(Division division, String type) {
        throw new IllegalStateException("Invalid " + (division == null ? "NULL_ENTITY" : division.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (division  == null ? null : division.toString()));
    }

}
