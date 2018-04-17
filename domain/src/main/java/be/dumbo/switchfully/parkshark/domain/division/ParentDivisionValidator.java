package be.dumbo.switchfully.parkshark.domain.division;

//copied code from http://www.baeldung.com/spring-mvc-custom-validator,
// https://stackoverflow.com/questions/11390034/create-custom-hibernate-validator-based-on-existing-hibernate-validator
//javavids spring web app tutorial

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ParentDivisionValidator implements ConstraintValidator<ParentDivisionConstraint, Integer> {

    @Override
    public boolean isValid(Integer parentDivisionId, ConstraintValidatorContext constraintValidatorContext) {
        return parentDivisionId == 100;
    }
}
