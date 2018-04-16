package be.dumbo.switchfully.parkshark.domain.parkinglot;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson;

import javax.persistence.*;

@Entity
@Table(name = "PARKINGLOTS")
public class ParkingLot {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="parkinglot_seq", sequenceName = "PARKINGLOTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkinglot_seq")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToOne
    @JoinColumn(name = "contact_person_id", referencedColumnName = "id")
    private ContactPerson contactPerson;

    @Embedded
    private Address address;

    //https://stackoverflow.com/questions/2243730/jpa-hibernate-embedded-and-enum
    @Enumerated
    @Embedded
    private BuildingType buildingType;

    private ParkingLot() {}

    private ParkingLot(ParkingLotBuilder parkingLotBuilder) {
        this.id = parkingLotBuilder.id;
        this.name = parkingLotBuilder.name;
        this.division = parkingLotBuilder.division;
        this.capacity = parkingLotBuilder.capacity;
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

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public static class ParkingLotBuilder {

        private Integer id;
        private String name;
        private Division division;
        private Integer capacity;
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

    }

}
