package be.dumbo.switchfully.parkshark.service.address;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

//copied from order solution switchfully

@Named
public class AddressValidator {

    private boolean isARequiredFieldEmptyOrNull(Address address) {
        return isNull(address) || isEmptyOrNull(address.getStreetName())
                || isEmptyOrNull(address.getStreetNumber())
                || isEmptyOrNull(address.getPostalCode())
                || isEmptyOrNull(address.getLabel());
    }

    private boolean isNull(Address address) {
        return address == null;
    }

    private boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    public boolean isValidForCreation(Address address) {
        return !isARequiredFieldEmptyOrNull(address);
    }

    public void throwInvalidStateException(Address address, String type) {
        throw new IllegalStateException("Invalid " + (address == null ? "NULL_ENTITY" : address.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (address == null ? null : address.toString()));
    }

}
