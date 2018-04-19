package be.dumbo.switchfully.parkshark.domain.parkinglot;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

// javax validation: http://www.baeldung.com/javax-validation

@Entity
@Table(name = "PARKINGLOTS")
public class ParkingLot {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name = "NAME")
    @NotNull(message = "Name cannot be null.")
    @NotBlank(message = "Name must be filled in.")
    private String name;

    @NotNull(message = "Division id cannot be null.")
    @NotBlank(message = "Division id must be filled in.")
    @Column(name = "DIVISION_ID")
    private String divisionId;

    @Column(name = "CAPACITY")
    @NotNull(message = "Capacity cannot be null.")
    private Integer capacity;

    @Column(name = "PRICE_PER_HOUR_IN_EURO")
    @NotNull(message = "Price per hour in euro cannot be null.")
    private BigDecimal pricePerHourInEuro;

    @NotNull(message = "Contact person cannot be null.")
    @Column(name = "CONTACT_PERSON_ID")
    private String contactPersonId;

    // copied and adapted code from order-jpa-solution-switchfully
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "STREET_NAME")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "STREET_NUMBER")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "POSTAL_CODE")),
            @AttributeOverride(name = "label", column = @Column(name = "LABEL"))
    })
    @NotNull(message = "Address cannot be null.")
    private Address address;

    //https://stackoverflow.com/questions/2243730/jpa-hibernate-embedded-and-enum
    //https://stackoverflow.com/questions/9839553/hibernate-map-enum-to-varchar
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Building type cannot be null.")
    private BuildingType buildingType;

    private ParkingLot() {}

    private ParkingLot(ParkingLotBuilder parkingLotBuilder) {
        this.id = parkingLotBuilder.id;
        this.name = parkingLotBuilder.name;
        this.divisionId = parkingLotBuilder.divisionId;
        this.capacity = parkingLotBuilder.capacity;
        this.pricePerHourInEuro = parkingLotBuilder.pricePerHourInEuro;
        this.contactPersonId = parkingLotBuilder.contactPersonId;
        this.address = parkingLotBuilder.address;
        this.buildingType = parkingLotBuilder.buildingType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public BigDecimal getPricePerHourInEuro() {
        return pricePerHourInEuro;
    }

    public String getContactPersonId() {
        return contactPersonId;
    }

    public Address getAddress() {
        return address;
    }

    public BuildingType getBuildingType() {
        return buildingType;
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

    public static class ParkingLotBuilder extends Builder<ParkingLot>{

        private String id;
        private String name;
        private String divisionId;
        private Integer capacity;
        private BigDecimal pricePerHourInEuro;
        private String contactPersonId;
        private Address address;
        private BuildingType buildingType;

        private ParkingLotBuilder() {}

        public static ParkingLotBuilder parkingLot() {
            return new ParkingLotBuilder();
        }

        public ParkingLotBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withDivisionId(String divisionId) {
            this.divisionId = divisionId;
            return this;
        }

        public ParkingLotBuilder withCapacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public ParkingLotBuilder withPricePerHourInEuro(BigDecimal pricePerHourInEuro) {
            this.pricePerHourInEuro = pricePerHourInEuro;
            return this;
        }

        public ParkingLotBuilder withContactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
            return this;
        }

        public ParkingLotBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ParkingLotBuilder withBuildingType(BuildingType buildingType) {
            this.buildingType = buildingType;
            return this;
        }

        @Override
        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }

}
