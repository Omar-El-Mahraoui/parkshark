package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.domain.address.Address;

import javax.persistence.*;

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
    private TelephoneNumber mobilePhoneNumber;

    @Embedded
    private TelephoneNumber telephoneNumber;

    @Embedded
    private Email email;

    @Embedded
    private Address address;

    private ContactPerson() {}

    public ContactPerson(ContactPersonBuilder contactPersonBuilder) {
        this.id = contactPersonBuilder.id;
        this.name = contactPersonBuilder.name;
        this.mobilePhoneNumber = contactPersonBuilder.mobilePhoneNumber;
        this.telephoneNumber = contactPersonBuilder.telephoneNumber;
        this.email = contactPersonBuilder.email;
        this.address = contactPersonBuilder.address;
    }

    public static class ContactPersonBuilder {

        private Integer id;
        private String name;
        private TelephoneNumber mobilePhoneNumber;
        private TelephoneNumber telephoneNumber;
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

        public ContactPersonBuilder withMobilePhoneNumber(TelephoneNumber mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public ContactPersonBuilder withTelephoneNumber(TelephoneNumber telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
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
