package be.dumbo.switchfully.parkshark.domain.parkinglot;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.address.AddressTestBuilder;
import be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot.ParkingLotBuilder;
import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.ContactPersonTestBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot.ParkingLotBuilder.parkingLot;

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
                        .withDivision(DivisionTestBuilder.aDivision().build())
                        .withCapacity(100)
                        .withContactPerson(ContactPersonTestBuilder.aContactPerson().build())
                        .withAddress(AddressTestBuilder.anAddress().build())
                        .withBuildingType(BuildingType.ABOVE_GROUND));
    }

    @Override
    public ParkingLot build() {
        return null;
    }
}