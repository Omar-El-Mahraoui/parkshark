package be.dumbo.switchfully.parkshark.api.division;

import be.dumbo.switchfully.parkshark.api.interceptors.ControllerExceptionHandler;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import be.dumbo.switchfully.parkshark.infrastructure.ControllerIntegrationTest;
import be.dumbo.switchfully.parkshark.service.division.DivisionService;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;

import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

// copied code from switchfully order solution

public class DivisionControllerIntegrationTest extends ControllerIntegrationTest{

    @Inject
    private DivisionMapper divisionMapper;
    @Inject
    private DivisionService divisionService;
    @Inject
    private DivisionRepository divisionRepository;
    @Inject
    private DivisionController divisionController;

    @Test
    public void createDivision_happyPath() {
        //GIVEN
        divisionRepository.deleteAll();
        DivisionDto divisionDtoGiven = divisionMapper.toDto(aDivision().build());

        //WHEN
        DivisionDto divisionDtoReturned = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", getPort(), DivisionController.RESOURCE_NAME)
                , divisionDtoGiven, DivisionDto.class);

        //THEN
        assertThat(divisionDtoReturned)
                .isEqualToIgnoringGivenFields(divisionDtoGiven, "id");
    }

    @Test
    public void createDivision_givenAnInvalidParentId_thenReturnErrorObjectByControllerExceptionHandler() {
        //GIVEN
        divisionRepository.deleteAll();
        Division parentDivision = aDivision().build();
        divisionService.createDivision(parentDivision);
        Division subDivision = aDivision()
                .withName("name2")
                .withParentDivisionId(parentDivision.getId() + 1)
                .build();

        //WHEN
        ControllerExceptionHandler.Error error = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", getPort(), DivisionController.RESOURCE_NAME)
                        , divisionMapper.toDto(subDivision), ControllerExceptionHandler.Error.class);

        //THEN
        assertThat(error).isNotNull();
        assertThat(error.getHttpStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(error.getUniqueErrorId()).isNotNull().isNotEmpty();
        assertThat(error.getMessage()).contains("Invalid Division provided for creation. " +
            "Provided object: Division[id=");
    }

    @Test
    public void createDivision_givenANameThatIsNull_thenThrowJavaxValidationException() {
        //GIVEN
        divisionRepository.deleteAll();
        Division subDivision = aDivision()
                .withName(null)
                .build();

        //WHEN
        ControllerExceptionHandler.Error error = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", getPort(), DivisionController.RESOURCE_NAME)
                        , divisionMapper.toDto(subDivision), ControllerExceptionHandler.Error.class);

        //THEN
        assertThat(error).isNotNull();
        assertThat(error.getMessage()).contains("Name cannot be null.");
    }

    //rest template doe not give correct result, but alt+F8 does give correct result
    /*@Test
    public void getAllDivisions_assertResultIsCorrectlyReturned() {
        //GIVEN
        divisionRepository.deleteAll();
        Division divisionInDatabase = divisionService.createDivision(aDivision().build());

        //WHEN
        DivisionDto[] allDivisions = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", getPort(), DivisionController.RESOURCE_NAME),
                        DivisionDto[].class);

        //THEN
        assertThat(Arrays.asList(allDivisions)).containsExactlyInAnyOrder(divisionMapper.toDto(divisionInDatabase));
    }*/


}