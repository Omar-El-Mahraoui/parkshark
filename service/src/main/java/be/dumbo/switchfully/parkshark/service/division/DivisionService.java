package be.dumbo.switchfully.parkshark.service.division;
// copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.domain.division.DivisionRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DivisionService {

    private DivisionRepository divisionRepository;
    private DivisionValidator divisionValidator;

    @Inject
    public DivisionService(DivisionRepository divisionRepository, DivisionValidator divisionValidator) {
        this.divisionRepository = divisionRepository;
        this.divisionValidator = divisionValidator;
    }


    public List<Division> getAllDivisions() {
        return divisionRepository.getAll();
    }

    public Division createDivision(Division division) {
        if (!divisionValidator.isValidForCreation(division, getAllDivisions())) {
            divisionValidator.throwInvalidStateException(division, "creation");
        }
        return divisionRepository.save(division);
    }
}
