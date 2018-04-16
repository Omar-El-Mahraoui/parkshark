package be.dumbo.switchfully.parkshark.api.division;

import be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.ControllerIntegrationTest;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import javax.inject.Inject;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

// copied code from switchfully order solution

public class DivisionControllerIntegrationTest extends ControllerIntegrationTest{

    @Inject
    private DivisionMapper divisionMapper;

    @Test
    public void createDivision() {
        //GIVEN
        DivisionDto divisionDtoGiven = divisionMapper.toDto(DivisionTestBuilder.aDivision().build());

        //WHEN
        DivisionDto divisionDtoReturned = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", getPort(), DivisionController.RESOURCE_NAME)
                , divisionDtoGiven, DivisionDto.class);

        //THEN
        assertThat(divisionDtoReturned)
                .isEqualToIgnoringGivenFields(divisionDtoGiven, "id");
    }


}