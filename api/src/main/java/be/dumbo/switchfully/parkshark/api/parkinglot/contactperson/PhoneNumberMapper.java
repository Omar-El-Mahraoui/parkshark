package be.dumbo.switchfully.parkshark.api.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.PhoneNumber;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;

import javax.inject.Named;

@Named
public class PhoneNumberMapper extends Mapper<PhoneNumberDto,PhoneNumber>{
    @Override
    public PhoneNumberDto toDto(PhoneNumber phoneNumber) {
        return PhoneNumberDto.phoneNumberDto()
                .withTelephoneNumber(phoneNumber.getTelephoneNumber())
                .withMobilePhoneNumber(phoneNumber.getMobilePhoneNumber());
    }

    @Override
    public PhoneNumber toDomain(PhoneNumberDto phoneNumberDto) {
        return null;
    }
}
