package be.dumbo.switchfully.parkshark.api.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.api.address.AddressMapper;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ContactPersonMapper extends Mapper<ContactPersonDto,ContactPerson> {

    private EmailMapper emailMapper;
    private PhoneNumberMapper phoneNumberMapper;
    private AddressMapper addressMapper;

    @Inject
    public ContactPersonMapper(EmailMapper emailMapper, PhoneNumberMapper phoneNumberMapper, AddressMapper addressMapper) {
        this.emailMapper = emailMapper;
        this.phoneNumberMapper = phoneNumberMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public ContactPersonDto toDto(ContactPerson contactPerson) {
        return ContactPersonDto.contactPersonDto()
                .withId(contactPerson.getId())
                .withName(contactPerson.getName())
                .withEmail(emailMapper.toDto(contactPerson.getEmail()))
                .withPhoneNumber(phoneNumberMapper.toDto(contactPerson.getPhoneNumber()))
                .withAddress(addressMapper.toDto(contactPerson.getAddress()));
    }

    @Override
    public ContactPerson toDomain(ContactPersonDto contactPersonDto) {
        return null;
    }
}
