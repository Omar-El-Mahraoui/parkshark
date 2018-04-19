package be.dumbo.switchfully.parkshark.api.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.api.address.AddressDto;

public class ContactPersonDto {

    private Integer id;
    private String name;
    private PhoneNumberDto phoneNumber;
    private EmailDto email;
    private AddressDto address;

    private ContactPersonDto() {}

    public static ContactPersonDto contactPersonDto() {
        return new ContactPersonDto();
    }

    public ContactPersonDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public ContactPersonDto withName(String name) {
        this.name = name;
        return this;
    }

    public ContactPersonDto withPhoneNumber(PhoneNumberDto phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ContactPersonDto withEmail(EmailDto email) {
        this.email = email;
        return this;
    }

    public ContactPersonDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumberDto getPhoneNumber() {
        return phoneNumber;
    }

    public EmailDto getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }
}
