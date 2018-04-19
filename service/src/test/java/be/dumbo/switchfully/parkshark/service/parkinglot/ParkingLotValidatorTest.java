package be.dumbo.switchfully.parkshark.service.parkinglot;

//copied and adapted code from order solution jpa switchfully

import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotTestBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotValidatorTest {

    @Test
    public void isValidForCreation_happyPath() {
        //GIVEN
        ParkingLot parkingLot = ParkingLotTestBuilder.aParkingLot().build();

        //WHEN
        Boolean isValidForCreation = new ParkingLotValidator().isValidForCreation(parkingLot);

        //THEN
        assertThat(isValidForCreation)
                .isTrue();
    }

    @Test
    public void isValidForCreation_givenAnId_thenReturnFalse() {
        //GIVEN
        ParkingLot parkingLot = ParkingLotTestBuilder.aParkingLot()
                                    .withId(1)
                                    .build();

        //WHEN
        Boolean isValidForCreation = new ParkingLotValidator().isValidForCreation(parkingLot);

        //THEN
        assertThat(isValidForCreation)
                .isFalse();
    }

}