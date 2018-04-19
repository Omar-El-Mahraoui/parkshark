/*
package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.address.AddressTestBuilder;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson.ContactPersonBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson.ContactPersonBuilder.contactPerson;
import static be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.PhoneNumberTestBuilder.aPhoneNumber;

public class ContactPersonTestBuilder extends Builder<ContactPerson>{

    private ContactPersonBuilder contactPersonBuilder;

    private ContactPersonTestBuilder() {}

    private ContactPersonTestBuilder(ContactPersonBuilder contactPersonBuilder) {
        this.contactPersonBuilder = contactPersonBuilder;
    }

    public static ContactPersonTestBuilder anEmptyContactPerson() {
        return new ContactPersonTestBuilder(contactPerson());
    }

    public static ContactPersonTestBuilder aContactPerson() {
        return new ContactPersonTestBuilder(contactPerson()
                    .withName("contactPerson1")
                    .withPhoneNumber(aPhoneNumber().build())
                    .withEmail(EmailTestBuilder.anEmail().build())
                    .withAddress(AddressTestBuilder.anAddress().build()));
    }

    @Override
    public ContactPerson build() {
        return contactPersonBuilder.build();
    }

    public ContactPersonTestBuilder withName(String name) {
        contactPersonBuilder.withName(name);
        return this;
    }

    public ContactPersonTestBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        contactPersonBuilder.withPhoneNumber(phoneNumber);
        return this;
    }

}
*/
