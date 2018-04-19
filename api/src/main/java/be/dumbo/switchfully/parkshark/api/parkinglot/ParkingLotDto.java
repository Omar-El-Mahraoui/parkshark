package be.dumbo.switchfully.parkshark.api.parkinglot;

import be.dumbo.switchfully.parkshark.api.address.AddressDto;
import be.dumbo.switchfully.parkshark.api.division.DivisionDto;
import be.dumbo.switchfully.parkshark.api.parkinglot.contactperson.ContactPersonDto;

public class ParkingLotDto {

    private Integer id;
    private String name;
    private DivisionDto division;
    private Integer capacity;
    private String pricePerHourInEuro;
    private ContactPersonDto contactPerson;
    private AddressDto address;
    private String buildingType;

    private ParkingLotDto() {}

    public static ParkingLotDto parkingLotDto() {
        return new ParkingLotDto();
    }

    public ParkingLotDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public ParkingLotDto withName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDto withDivision(DivisionDto division) {
        this.division = division;
        return this;
    }

    public ParkingLotDto withCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public ParkingLotDto withPricePerHourInEuro(String pricePerHourInEuro) {
        this.pricePerHourInEuro = pricePerHourInEuro;
        return this;
    }

    public ParkingLotDto withContactPerson(ContactPersonDto contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ParkingLotDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public ParkingLotDto withBuildingType(String buildingType) {
        this.buildingType = buildingType;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DivisionDto getDivision() {
        return division;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getPricePerHourInEuro() {
        return pricePerHourInEuro;
    }

    public ContactPersonDto getContactPerson() {
        return contactPerson;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getBuildingType() {
        return buildingType;
    }
}
