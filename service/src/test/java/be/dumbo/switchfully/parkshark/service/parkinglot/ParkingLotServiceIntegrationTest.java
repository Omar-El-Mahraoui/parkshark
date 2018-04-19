package be.dumbo.switchfully.parkshark.service.parkinglot;

// copied and adapted code from order dolution jpa solution switchfully

import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import be.dumbo.switchfully.parkshark.infrastructure.ServiceIntegrationTest;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotTestBuilder.aParkingLot;
import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotServiceIntegrationTest extends ServiceIntegrationTest {

    @Inject
    private ParkingLotService parkingLotService;

    @Inject
    private ParkingLotRepository parkingLotRepository;

    @Test
    public void createParkingLot_happyPath() {
        //GIVEN
        parkingLotRepository.deleteAll();
        ParkingLot parkingLotToCreate = aParkingLot().build();

        //WHEN
        ParkingLot parkingLotCreated = parkingLotService.createParkingLot(parkingLotToCreate);

        //THEN
        assertThat(parkingLotRepository.getAll().get(0))
                .isEqualTo(parkingLotCreated)
                .isEqualTo(parkingLotToCreate);
        assertThat(parkingLotCreated.getId()).isNotNull();
    }

    @Test
    public void getAllParkingLots() {
        //GIVEN
        parkingLotRepository.deleteAll();
        ParkingLot parkingLotToCreate1 = parkingLotRepository.save(aParkingLot().build());
        ParkingLot parkingLotToCreate2 = parkingLotRepository.save(aParkingLot().build());
        ParkingLot parkingLotToCreate3 = parkingLotRepository.save(aParkingLot().build());

        //WHEN
        List<ParkingLot> parkingLotListReturned = parkingLotService.getAllParkingLots();

        //THEN
        assertThat(parkingLotListReturned).containsExactlyInAnyOrder(parkingLotToCreate1
                                            ,parkingLotToCreate2,parkingLotToCreate3);
    }

}