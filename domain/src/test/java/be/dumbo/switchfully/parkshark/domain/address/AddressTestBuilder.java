package be.dumbo.switchfully.parkshark.domain.address;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.address.Address.AddressBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.address.Address.AddressBuilder.address;

public class AddressTestBuilder extends Builder<Address>{

    private AddressBuilder addressBuilder;

    private AddressTestBuilder() {}

    private AddressTestBuilder(AddressBuilder addressBuilder) {
        this.addressBuilder = addressBuilder;
    }

    public static AddressTestBuilder anEmptyAddress() {
        return new AddressTestBuilder(address());
    }

    public static AddressTestBuilder anAddress() {
        return new AddressTestBuilder(address()
                    .withStreetName("streetName1")
                    .withStreetNumber("streetNumber1")
                    .withPostalCode("postalCode1")
                    .withLabel("label1"));
    }

    @Override
    public Address build() {
        return addressBuilder.build();
    }

    public AddressTestBuilder withStreetName(String streetName) {
        addressBuilder.withStreetName(streetName);
        return this;
    }

    public AddressTestBuilder withStreetNumber(String streetNumber) {
        addressBuilder.withStreetNumber(streetNumber);
        return this;
    }

    public AddressTestBuilder withPostalCode(String postalCode) {
        addressBuilder.withPostalCode(postalCode);
        return this;
    }

    public AddressTestBuilder withLabel(String label) {
        addressBuilder.withLabel(label);
        return this;
    }
}