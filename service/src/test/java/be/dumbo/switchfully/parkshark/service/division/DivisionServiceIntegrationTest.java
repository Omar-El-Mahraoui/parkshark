package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import be.dumbo.switchfully.parkshark.infrastructure.ServiceIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DivisionServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private DivisionService divisionService;

    @Test
    public void getAll_givenADivisionTable_returnListOfAllDivisions() {
        //GIVEN
        divisionRepository.deleteAll();

        Division division1 = divisionRepository.save(aDivision().build());
        Division division2 = divisionRepository.save(aDivision().withName("name2").build());
        Division division3 = divisionRepository.save(aDivision().withName("name3").build());
        //WHEN
        List<Division> actualResult = divisionService.getAllDivisions();
        //THEN
        assertThat(actualResult).containsExactlyInAnyOrder(division1, division2, division3);
        assertThat(actualResult.get(0).getId()).isNotNull();
        assertThat(actualResult.get(1).getId()).isNotNull();
        assertThat(actualResult.get(2).getId()).isNotNull();
    }

    @Test
    public void createDivision_happyPath() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division = divisionService.createDivision(aDivision().build());

        //WHEN
        List<Division> actualResult = divisionService.getAllDivisions();

        //THEN
        assertThat(actualResult).containsExactlyInAnyOrder(division);
    }

    @Test
    public void createDivision_givenANonExistingparentDivisionId_thenThrowException() {
        //GIVEN
        divisionRepository.deleteAll();

        Division parentDivisionId = aDivision().build();
        divisionService.createDivision(parentDivisionId);
        Division subDivision = aDivision()
                                .withParentDivisionId(parentDivisionId.getId() + 1)
                                .build();

        //WHEN

        //THEN
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(()->divisionService.createDivision(subDivision))
                .withMessage("Invalid " + (subDivision == null ? "NULL_ENTITY" : subDivision.getClass().getSimpleName())
                        + " provided for " + "creation" + ". Provided object: " + (subDivision  == null ? null : subDivision.toString()));
    }

    @Test
    public void createDivision_givenANameThatIsNull_thenReturnErrorObjectByControllerExceptionHandler() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division = aDivision()
                .withName(null)
                .build();

        //WHEN
        assertThatExceptionOfType(ConstraintViolationException.class)
            .isThrownBy(()->divisionService.createDivision(division))
            .withMessageContaining("Name cannot be null.");

        //THEN

    }

    @Test
    public void createDivision_givenANameThatIsBlank_thenReturnErrorObjectByControllerExceptionHandler() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division = aDivision()
                .withName("")
                .build();

        //WHEN
        assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()->divisionService.createDivision(division))
                .withMessageContaining("Name must be filled in.");

        //THEN

    }

    /*@Test
    public void createDivision_givenADivsionWithSameNameAsDivisionInDatabse_thenThrowException() {
        //GIVEN
        divisionRepository.deleteAll();
        divisionRepository.save(aDivision().build());

        //WHEN

        //THEN
        assertThatExceptionOfType(org.hibernate.exception.ConstraintViolationException.class)
                .isThrownBy(()->divisionService.createDivision(aDivision().build()));
    }*/

}
