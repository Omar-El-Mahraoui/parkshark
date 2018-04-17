package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.ServiceIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import java.util.List;

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

        Division division1 = DivisionTestBuilder.aDivision().build();
        assertThat(division1.getId()).isEqualTo(null);

        Division division2 = DivisionTestBuilder.aDivision().build();
        assertThat(division2.getId()).isEqualTo(null);

        Division division3 = DivisionTestBuilder.aDivision().build();
        assertThat(division3.getId()).isEqualTo(null);

        divisionRepository.save(DivisionTestBuilder.aDivision().build());
        divisionRepository.save(DivisionTestBuilder.aDivision().build());
        divisionRepository.save(DivisionTestBuilder.aDivision().build());
        //WHEN
        List<Division> actualResult = divisionService.getAllDivisions();
        //THEN
        assertThat(actualResult).hasSize(3);
        assertThat(actualResult.get(0).getId()).isNotNull();
        assertThat(actualResult.get(1).getId()).isNotNull();
        assertThat(actualResult.get(2).getId()).isNotNull();
    }

    @Test
    public void createDivision_happyPath() {
        //GIVEN
        divisionRepository.deleteAll();

        Division division = DivisionTestBuilder.aDivision().build();
        divisionRepository.save(DivisionTestBuilder.aDivision().build());

        //WHEN
        List<Division> actualResult = divisionService.getAllDivisions();

        //THEN
        assertThat(division.getId()).isEqualTo(null);
        assertThat(actualResult.get(0)).isNotNull();
        assertThat(actualResult.get(0)).isEqualToIgnoringGivenFields(division, "id");
    }

    /*@Test
    public void createDivision_givenANonExistingParentDivisionId_thenThrowException() {
        //GIVEN
        divisionRepository.deleteAll();

        Division parentDivision = DivisionTestBuilder.aDivision().build();
        divisionService.createDivision(parentDivision);
        Division subDivision = DivisionTestBuilder.aDivision()
                                                    .withParentDivision(parentDivision.getId() + 1)
                                                    .build();

        //WHEN

        //THEN
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(()->divisionService.createDivision(subDivision))
                .withMessage("Invalid " + (subDivision == null ? "NULL_ENTITY" : subDivision.getClass().getSimpleName())
                        + " provided for " + "creation" + ". Provided object: " + (subDivision  == null ? null : subDivision.toString()));
    }*/

    @Test
    public void createDivision_givenANameThatIsNull_thenReturnErrorObjectByControllerExceptionHandler() {
        //GIVEN
        divisionService.deleteAllDivisionsFromDatabase();
        Division division = DivisionTestBuilder.aDivision()
                .withName(null)
                .build();

        //WHEN
        assertThatExceptionOfType(ConstraintViolationException.class)
            .isThrownBy(()->divisionService.createDivision(division))
            .withMessageContaining("Name cannot be null.");

        //THEN

    }

}
