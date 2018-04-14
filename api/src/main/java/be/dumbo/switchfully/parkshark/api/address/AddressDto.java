package be.dumbo.switchfully.parkshark.api.address;

//copied and adpated code from order solution switchfully

public class AddressDto {

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String label;

    private AddressDto() {}

    public static AddressDto addressDto() {
        return new AddressDto();
    }

    public AddressDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressDto withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressDto withLabel(String label) {
        this.label = label;
        return this;
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
}
