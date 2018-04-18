package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "CONTACT_PERSONS")
public class ContactPerson {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="contactPerson_seq", sequenceName = "CONTACT_PERSONS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactPerson_seq")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    @NotNull
    private Email email;

    @Embedded
    @NotNull(message = "Address cannot be null.")
    private Address address;

    private ContactPerson() {}

    public ContactPerson(ContactPersonBuilder contactPersonBuilder) {
        this.id = contactPersonBuilder.id;
        this.name = contactPersonBuilder.name;
        this.phoneNumber = contactPersonBuilder.phoneNumber;
        this.email = contactPersonBuilder.email;
        this.address = contactPersonBuilder.address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getMobilePhoneNumber() {
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

        private Integer id;
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

        public ContactPersonBuilder withId(Integer id) {
            this.id = id;
            return this;
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
