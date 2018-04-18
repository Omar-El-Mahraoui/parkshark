package be.dumbo.switchfully.parkshark.domain.address;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @Column(name="STREET_NAME")
    @NotNull(message = "Street name cannot be null.")
    @NotBlank(message = "Street name must be filled in.")
    private String streetName;

    @Column(name="STREET_NUMBER")
    @NotNull(message = "Street number cannot be null.")
    @NotBlank(message = "Street number must be filled in.")
    private String streetNumber;

    @Column(name="POSTAL_CODE")
    @NotNull(message = "Postal code cannot be null.")
    @NotBlank(message = "Postal code must be filled in.")
    private String postalCode;

    @Column(name="LABEL")
    @NotNull(message = "Label cannot be null.")
    @NotBlank(message = "Label must be filled in.")
    private String label;

    private Address() {
    }

    private Address(AddressBuilder addressBuilder) {
        this.streetName = addressBuilder.getStreetName();
        this.streetNumber = addressBuilder.getStreetNumber();
        this.postalCode = addressBuilder.getPostalCode();
        this.label = addressBuilder.getLabel();
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

    public static class AddressBuilder {

        private String streetName;
        private String streetNumber;
        private String postalCode;
        private String label;

        private AddressBuilder() {}

        public static AddressBuilder address() {
            return new AddressBuilder();
        }

        public Address build() {
            return new Address(this);
        }

        public AddressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withLabel(String label) {
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
}
