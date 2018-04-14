package be.dumbo.switchfully.parkshark.domain.member;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.domain.licenseplate.LicensePlate;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="MEMBERS")
public class Member {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="members_seq", sequenceName = "MEMBERS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "members_seq")
    private int id;
    @Column(name="NAME")
    private String name;
    @Embedded
    private Address address;
    @Column(name="MOBILE_PHONE")
    private String mobilePhone;
    @Column(name="FIXED_LINE")
    private String fixedLine;
    @Column(name="EMAIL")
    private String email;
    @OneToOne
    @JoinColumn(name="FK_LICENSE_PLATE")
    private LicensePlate licensePlate;
    @Column(name="REGISTRATION_DATE")
    private LocalDate registrationDate;

    private Member() {}

    private Member(MemberBuilder memberBuilder) {
        this.name = memberBuilder.getName();
        this.address = memberBuilder.getAddress();
        this.mobilePhone = memberBuilder.getMobilePhone();
        this.fixedLine = memberBuilder.getFixedLine();
        this.licensePlate = memberBuilder.getLicensePlate();
        this.registrationDate = memberBuilder.getRegistrationDate();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getMobilePhone() { return mobilePhone; }

    public String getFixedLine() { return fixedLine; }

    public String getEmail() {  return email; }

    public static class MemberBuilder {

        private String name;
        private Address address;
        private LicensePlate licensePlate;
        private LocalDate registrationDate;
        private String mobilePhone;
        private String fixedLine;
        private String email;

        private MemberBuilder() {}

        public static MemberBuilder member() {
            return new MemberBuilder();
        }

        public Member build() {
            return new Member(this);
        }

        public MemberBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }


        public MemberBuilder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public MemberBuilder withRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        public LicensePlate getLicensePlate() {
            return licensePlate;
        }

        public LocalDate getRegistrationDate() {
            return registrationDate;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public String getFixedLine() {
            return fixedLine;
        }

        public String getEmail() {
            return email;
        }
    }
}
