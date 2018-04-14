package be.dumbo.switchfully.parkshark.api.address;

//copied and adpated code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;

import javax.inject.Named;

import static be.dumbo.switchfully.parkshark.api.address.AddressDto.addressDto;
import static be.dumbo.switchfully.parkshark.domain.address.Address.AddressBuilder.address;

@Named
public class AddressMapper extends Mapper<AddressDto, Address>{

    @Override
    public AddressDto toDto(Address address) {
        return addressDto()
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber())
                .withPostalCode(address.getPostalCode())
                .withLabel(address.getLabel());
    }

    @Override
    public Address toDomain(AddressDto addressDto) {
        return address()
                .withStreetName(addressDto.getStreetName())
                .withStreetNumber(addressDto.getStreetNumber())
                .withPostalCode(addressDto.getPostalCode())
                .withLabel(addressDto.getLabel())
                .build();
    }
}
