package be.dumbo.switchfully.parkshark.domain.parkinglot;

import be.dumbo.switchfully.parkshark.infrastructure.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotTestBuilder.aParkingLot;
import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotRepositoryIntegrationTest extends IntegrationTest{

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    public void save_givenAParkingLot_thenSaveTheParkingLotInDatabaseAndReturnTheDivisionWithTheId() {
        //GIVEN
        parkingLotRepository.deleteAll();
        ParkingLot parkingLotGiven = aParkingLot().build();

        //WHEN
        ParkingLot parkingLotCreated = parkingLotRepository.save(parkingLotGiven);

        //THEN
        assertThat(parkingLotCreated.getId()).isNotNull();
    }


}
