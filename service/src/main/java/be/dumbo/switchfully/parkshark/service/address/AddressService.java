package be.dumbo.switchfully.parkshark.service.address;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.repository.address.AddressRepository;

import javax.inject.Inject;
import javax.inject.Named;

//copied from order solution switchfully

@Named
public class AddressService {

    private AddressRepository addressRepository;
    private AddressValidator addressValidator;

    @Inject
    public AddressService(AddressRepository addressRepository, AddressValidator addressValidator) {
        this.addressRepository = addressRepository;
        this.addressValidator = addressValidator;
    }

    public Address registerMember(Address address) {
        if (!addressValidator.isValidForCreation(address)) {
            addressValidator.throwInvalidStateException(address, "registration");
        }
        return addressRepository.save(address);
    }

}
