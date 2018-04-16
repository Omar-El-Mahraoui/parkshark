package be.dumbo.switchfully.parkshark.api.division;

import be.dumbo.switchfully.parkshark.api.interceptors.ControllerExceptionHandler;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.ControllerIntegrationTest;
import be.dumbo.switchfully.parkshark.service.division.DivisionService;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

// copied code from switchfully order solution

public class DivisionControllerIntegrationTest extends ControllerIntegrationTest{

    @Inject
    private DivisionMapper divisionMapper;
    @Inject
    private DivisionRepository divisionRepository;
    @Inject
    private DivisionService divisionService;

    @Test
    public void createDivision_happyPath() {
        //GIVEN
        divisionRepository.deleteAll();
        DivisionDto divisionDtoGiven = divisionMapper.toDto(DivisionTestBuilder.aDivision().build());

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
        Division parentDivision = DivisionTestBuilder.aDivision().build();
        divisionService.createDivision(parentDivision);
        Division subDivision = DivisionTestBuilder.aDivision()
                .withParentDivision(parentDivision.getId() + 1)
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


}