package be.dumbo.switchfully.parkshark.service.division;

import be.dumbo.switchfully.parkshark.Application;
import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.repository.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class DivisionServiceIntegrationTest {

    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private DivisionService divisionService;

    @Test
    public void getAll_givenADivisionTable_returnListOfAllDivisions() {
        //GIVEN
        divisionRepository.deleteAll();
        Division division1 = divisionRepository.save(new Division("DivisionABC","SomeOldName","Maarten Supreme Leader"));
        Division division2 = divisionRepository.save(new Division("DivisionDEF","SomeOtherOldName","Omar"));
        Division division3 = divisionRepository.save(new Division("DivisionGHI","SomeLastOldName","Brecht"));
        //WHEN
        List<Division> retrievedDivisions = divisionService.getAllDivisions();
        //THEN
        Assertions.assertThat(retrievedDivisions).containsExactlyInAnyOrder(division1,division2,division3);
    }

}