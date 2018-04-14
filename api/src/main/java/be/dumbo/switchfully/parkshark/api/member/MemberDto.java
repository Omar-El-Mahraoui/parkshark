package be.dumbo.switchfully.parkshark.api.member;

//copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.api.licenseplate.LicensePlateDto;

import java.time.LocalDate;

public class MemberDto {

    private String name;
    private LicensePlateDto licensePlate;
    private String registrationDate;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String label;
    private String mobilePhone;
    private String fixedLine;
    private String email;

    private MemberDto() {}

    public static MemberDto memberDto() {
        return new MemberDto();
    }

    public MemberDto withName(String name) {
        this.name = name;
        return this;
    }

    public MemberDto withLicensePlate(LicensePlateDto licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public MemberDto withRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public MemberDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public MemberDto withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public MemberDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public MemberDto withLabel(String label) {
        this.label = label;
        return this;
    }

    public MemberDto withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public MemberDto withFixedLine(String fixedLine) {
        this.fixedLine = fixedLine;
        return this;
    }

    public MemberDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }



    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLabel() {
        return label;
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
