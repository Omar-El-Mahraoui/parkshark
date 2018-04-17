/*
package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.Arrays;

import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;
import static org.assertj.core.api.Assertions.assertThat;

//copied and adapted code from order solution switchfully

public class DivisionServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private DivisionService divisionService;
    private DivisionValidator divisionValidatorMock;
    private DivisionRepository divisionRepositoryMock;

    @Before
    public void setup() {
        divisionValidatorMock = Mockito.mock(DivisionValidator.class);
        divisionRepositoryMock = Mockito.mock(DivisionRepository.class);
        divisionService = new DivisionService(divisionRepositoryMock, divisionValidatorMock);
    }

    @Test
    public void createDivision_happyPath() {
        //GIVEN
        Division division = aDivision().build();
        Mockito.when(divisionValidatorMock.isValidForCreation(division, Arrays.asList(division)))
                .thenReturn(true);
        Mockito.when(divisionRepositoryMock.save(division)).thenReturn(aDivision().withId(1).build());

        //WHEN
        Division createdDivision = divisionService.createDivision(division);

        //THEN
        assertThat(createdDivision.getId()).isNotNull();
    }

    @Test
    public void createDivision_givenADivisionThatIsNotValidForCreation_thenThrowException() {
        //GIVEN
        Division division = aDivision().build();
        Mockito.when(divisionValidatorMock.isValidForCreation(division, Arrays.asList(division)))
                .thenReturn(false);
        Mockito.doThrow(IllegalStateException.class).when(divisionValidatorMock)
                .throwInvalidStateException(division, "creation");
        expectedException.expect(IllegalStateException.class);

        //WHEN
        divisionService.createDivision(division);

        //THEN

    }

}
*/
