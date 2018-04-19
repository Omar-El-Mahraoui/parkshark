/*
package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Embeddable
public class ContactPerson {

    @Column(name = "CONTACT_PERSON_NAME")
    @NotNull(message = "Name cannot be null.")
    private String name;

    @NotNull(message = "Phone number cannot be null.")
    // copied and adapted code from order-jpa-solution-switchfully
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "telephoneNumber", column = @Column(name = "CONTACT_PERSON_TELE_PHONE_NUMBER")),
            @AttributeOverride(name = "mobilePhoneNumber", column = @Column(name = "CONTACT_PERSON_MOBILE_PHONE_NUMBER"))
    })
    private PhoneNumber phoneNumber;

    // copied and adapted code from order-jpa-solution-switchfully
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "complete", column = @Column(name = "CONTACT_PERSON_EMAIL"))
    })
    @NotNull(message = "Email cannot be null.")
    private Email email;

    // copied and adapted code from order-jpa-solution-switchfully
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "CONTACT_PERSON_STREET_NAME")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "CONTACT_PERSON_STREET_NUMBER")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "CONTACT_PERSON_POSTAL_CODE")),
            @AttributeOverride(name = "label", column = @Column(name = "CONTACT_PERSON_LABEL"))
    })
    @NotNull(message = "Address cannot be null.")
    private Address address;

    private ContactPerson() {}

    public ContactPerson(ContactPersonBuilder contactPersonBuilder) {
        this.name = contactPersonBuilder.name;
        this.phoneNumber = contactPersonBuilder.phoneNumber;
        this.email = contactPersonBuilder.email;
        this.address = contactPersonBuilder.address;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    //copied from provided example codelab02 switchfully orm codelabs
    @Override
    public boolean equals(Object other){
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public static class ContactPersonBuilder {

        private String name;
        private PhoneNumber phoneNumber;
        private Email email;
        private Address address;

        private ContactPersonBuilder() {}

        public static ContactPersonBuilder contactPerson() {
            return new ContactPersonBuilder();
        }

        public ContactPerson build() {
            return new ContactPerson(this);
        }

        public ContactPersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ContactPersonBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ContactPersonBuilder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public ContactPersonBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

    }

}
*/
