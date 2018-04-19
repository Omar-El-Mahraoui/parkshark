/*
package be.dumbo.switchfully.parkshark.domain.parkinglot;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.address.Address;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot.ParkingLotBuilder;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPerson;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import java.math.BigDecimal;

import static be.dumbo.switchfully.parkshark.domain.address.AddressTestBuilder.anAddress;
import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;
import static be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot.ParkingLotBuilder.parkingLot;
import static be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPersonTestBuilder.aContactPerson;

public class ParkingLotTestBuilder extends Builder<ParkingLot> {

    private ParkingLotBuilder parkingLotBuilder;

    private ParkingLotTestBuilder() {}

    private ParkingLotTestBuilder(ParkingLotBuilder parkingLotBuilder) {
        this.parkingLotBuilder = parkingLotBuilder;
    }

    public static ParkingLotTestBuilder anEmptyParkingLot() {
        return new ParkingLotTestBuilder(parkingLot());
    }

    public static ParkingLotTestBuilder aParkingLot() {
        return new ParkingLotTestBuilder(parkingLot()
                        .withName("parkingLot1")
                        .withDivision(aDivision().build())
                        .withCapacity(100)
                        .withPricePerHourInEuro(BigDecimal.valueOf(5))
                        .withContactPerson(aContactPerson().build())
                        .withAddress(anAddress().build())
                        .withBuildingType(BuildingType.ABOVE_GROUND));
    }

    @Override
    public ParkingLot build() {
        return parkingLotBuilder.build();
    }

    public ParkingLotTestBuilder withId(Integer id) {
        parkingLotBuilder.withId(id);
        return this;
    }

    public ParkingLotTestBuilder withName(String name) {
        parkingLotBuilder.withName(name);
        return this;
    }

    public ParkingLotTestBuilder withDivision(Division division) {
        parkingLotBuilder.withDivision(division);
        return this;
    }

    public ParkingLotTestBuilder withCapacity(Integer capacity) {
        parkingLotBuilder.withCapacity(capacity);
        return this;
    }

    public ParkingLotTestBuilder withPricePerHourInEuro(BigDecimal pricePerHourInEuro) {
        parkingLotBuilder.withPricePerHourInEuro(pricePerHourInEuro);
        return this;
    }

    public ParkingLotTestBuilder withContactPerson(ContactPerson contactPerson) {
        parkingLotBuilder.withContactPerson(contactPerson);
        return this;
    }

    public ParkingLotTestBuilder withAddress(Address address) {
        parkingLotBuilder.withAddress(address);
        return this;
    }

    public ParkingLotTestBuilder withBuildingType(BuildingType buildingType) {
        parkingLotBuilder.withBuildingType(buildingType);
        return this;
    }
}
*/
