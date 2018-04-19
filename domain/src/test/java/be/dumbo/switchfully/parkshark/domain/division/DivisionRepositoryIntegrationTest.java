package be.dumbo.switchfully.parkshark.domain.division;

import be.dumbo.switchfully.parkshark.infrastructure.RepositoryIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;

public class DivisionRepositoryIntegrationTest extends RepositoryIntegrationTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    public void deleteAll_givenNotEmptyDivisionTable_thenEmptyDivisionTable() {
        //GIVEN

        //WHEN
        Division returnedDivision = divisionRepository.save(aDivision().build());
        divisionRepository.deleteAll();
        //THEN
        Assertions.assertThat(divisionRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void save_createDivisionReturnsDivisionWithId() {
        //GIVEN
        divisionRepository.deleteAll();
        //WHEN
        Division returnedDivision = divisionRepository.save(aDivision().build());
        //THEN
        Assertions.assertThat(returnedDivision).isNotNull();
        Assertions.assertThat(returnedDivision.getId()).isNotNull();
    }

    @Test
    public void getAll_returnsAllDivisions() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division1 = divisionRepository.save(aDivision().build());
        Division division2 = divisionRepository.save(aDivision().withName("name2").build());
        //WHEN
        List<Division> retrievedDivisions = divisionRepository.getAll();
        //THEN
        Assertions.assertThat(retrievedDivisions).containsExactlyInAnyOrder(division1, division2);
    }

}


