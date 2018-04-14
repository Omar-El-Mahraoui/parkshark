package be.dumbo.switchfully.parkshark.domain.division;

import be.dumbo.switchfully.parkshark.TestApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestApplication.class)
public class DivisionRepositoryIntegrationTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    public void deleteAll_givenNotEmptyDivisionTable_thenEmptyDivisionTable() {
        //GIVEN

        //WHEN
        Division returnedDivision = divisionRepository.save(DivisionTestBuilder.aDivision().build());
        divisionRepository.deleteAll();
        //THEN
        Assertions.assertThat(divisionRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void save_createDivisionReturnsDivisionWithId() {
        //GIVEN
        divisionRepository.deleteAll();
        //WHEN
        Division returnedDivision = divisionRepository.save(DivisionTestBuilder.aDivision().build());
        //THEN
        Assertions.assertThat(returnedDivision).isNotNull();
        Assertions.assertThat(returnedDivision.getId()).isNotZero();
    }

    @Test
    public void getAll_returnsAllDivisions() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division1 = divisionRepository.save(DivisionTestBuilder.aDivision().build());
        //WHEN
        List<Division> retrievedDivisions = divisionRepository.getAll();
        //THEN
        Assertions.assertThat(retrievedDivisions).containsExactlyInAnyOrder(division1);
    }

}


