package be.dumbo.switchfully.parkshark.domain.parkinglot;

import be.dumbo.switchfully.parkshark.infrastructure.RepositoryIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotTestBuilder.aParkingLot;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class ParkingLotRepositoryIntegrationTest extends RepositoryIntegrationTest{

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    /*//https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-customconstraints.html#validator-customconstraints-using
    private static Validator validator;
    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }*/

    @Test
    public void save_happyPath_thenSaveTheParkingLotInDatabaseAndReturnTheParkingLotWithItsId() {
        //GIVEN
        parkingLotRepository.deleteAll();
        ParkingLot parkingLotGiven = aParkingLot().build();

        //WHEN
        ParkingLot parkingLotCreated = parkingLotRepository.save(parkingLotGiven);

        //THEN
        assertThat(parkingLotCreated.getId()).isNotNull();
    }

    /*@Test
    public void save_givenAnInvalidParkingLot_thenThrowException() {
        //GIVEN
        parkingLotRepository.deleteAll();
        ParkingLot parkingLotGiven = anEmptyParkingLot()

                                        .build();

        //WHEN

        //THEN
        //https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-customconstraints.html#validator-customconstraints-using
        Set<String> violationMessages = new HashSet<>();
        Set<ConstraintViolation<ParkingLot>> constraintViolations =
                validator.validate(parkingLotGiven);
        assertThat("Parking lot is not valid:\n" + StringUtils.join(violationMessages, "\n"))
                .contains(constraintViolations.iterator().next().getMessage());
    }*/

    @Test
    public void getAll_returnAllParkingLotsInTheDatabase() {
        //GIVEN
        parkingLotRepository.deleteAll();
        parkingLotRepository.save(aParkingLot().build());
        parkingLotRepository.save(aParkingLot().build());
        parkingLotRepository.save(aParkingLot().build());

        //WHEN
        List<ParkingLot> parkingLotsReturned = parkingLotRepository.getAll();

        //THEN
        assertThat(parkingLotsReturned).hasSize(3);
    }


}
