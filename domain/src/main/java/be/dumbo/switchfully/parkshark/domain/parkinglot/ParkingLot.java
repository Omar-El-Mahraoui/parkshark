package be.dumbo.switchfully.parkshark.domain.parkinglot;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

// javax validation: http://www.baeldung.com/javax-validation

@Entity
@Table(name = "PARKINGLOTS")
public class ParkingLot {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="parkinglot_seq", sequenceName = "PARKINGLOTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkinglot_seq")
    private Integer id;

    @Column(name = "NAME")
    @NotNull(message = "Name cannot be null.")
    private String name;

    // https://github.com/cegeka/switchfully/blob/solutions/03-databases/02-ORM/01-jpa/src/main/java/codelab04/be/switchfully/person/Person.java
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @NotNull(message = "Division cannot be null.")
    private Division division;

    @Column(name = "capacity")
    @NotNull(message = "Capacity cannot be null.")
    private Integer capacity;

    @Column(name = "price_per_hour_in_euro")
    @NotNull(message = "Price cannot be null.")
    private BigDecimal pricePerHourInEuro;

    // https://github.com/cegeka/switchfully/blob/solutions/03-databases/02-ORM/01-jpa/src/main/java/codelab04/be/switchfully/person/Person.java
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_person_id", referencedColumnName = "id")
    @NotNull(message = "Contact person cannot be null.")
    private ContactPerson contactPerson;

    @Embedded
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
        this.division = parkingLotBuilder.division;
        this.capacity = parkingLotBuilder.capacity;
        this.pricePerHourInEuro = parkingLotBuilder.pricePerHourInEuro;
        this.contactPerson = parkingLotBuilder.contactPerson;
        this.address = parkingLotBuilder.address;
        this.buildingType = parkingLotBuilder.buildingType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Division getDivision() {
        return division;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public BigDecimal getPricePerHourInEuro() {
        return pricePerHourInEuro;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
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

        private Integer id;
        private String name;
        private Division division;
        private Integer capacity;
        private BigDecimal pricePerHourInEuro;
        private ContactPerson contactPerson;
        private Address address;
        private BuildingType buildingType;

        private ParkingLotBuilder() {}

        public static ParkingLotBuilder parkingLot() {
            return new ParkingLotBuilder();
        }

        public ParkingLotBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withDivision(Division division) {
            this.division = division;
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

        public ParkingLotBuilder withContactPerson(ContactPerson contactPerson) {
            this.contactPerson = contactPerson;
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
