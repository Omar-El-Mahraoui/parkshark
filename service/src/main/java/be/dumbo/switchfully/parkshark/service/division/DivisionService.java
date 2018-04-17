package be.dumbo.switchfully.parkshark.service.division;
// copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Named
@Transactional
@Validated
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Inject
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }


    public List<Division> getAllDivisions() {
        return divisionRepository.getAll();
    }

    //http://www.baeldung.com/spring-mvc-custom-validator
    public Division createDivision(@Valid Division division) {
        /*if (!divisionValidator.isValidForCreation(division, getAllDivisions())) {
            divisionValidator.throwInvalidStateException(division, "creation");
        }*/
        /*if(result.hasErrors()) {
            throw new ConstraintViolationException("Invalid parent division id", null);
        }*/
        return divisionRepository.save(division);
    }

    public void deleteAllDivisionsFromDatabase() {
        divisionRepository.deleteAll();
    }
}
