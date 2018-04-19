/*
package be.dumbo.switchfully.parkshark.domain.division;

//copied code from http://www.baeldung.com/spring-mvc-custom-validator,
// https://stackoverflow.com/questions/11390034/create-custom-hibernate-validator-based-on-existing-hibernate-validator
//javavids spring web app tutorial

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.stream.Collectors;

@Named
public class parentDivisionIdValidator implements ConstraintValidator<parentDivisionIdConstraint, Integer> {

    @Inject
    private DivisionRepository divisionRepository;

    @Override
    public void initialize(parentDivisionIdConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer parentDivisionId, ConstraintValidatorContext constraintValidatorContext) {
        return parentDivisionId == null
                || divisionRepository.getAll().stream()
                .map(division -> division.getId())
                .collect(Collectors.toList())
                .contains(parentDivisionId);
    }

//*
/https://stackoverflow.com/questions/37958145/autowired-gives-null-value-in-custom-constraint-validator
    @Bean
    public Validator validator (final AutowireCapableBeanFactory autowireCapableBeanFactory) {

        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure().constraintValidatorFactory(new SpringConstraintValidatorFactory(autowireCapableBeanFactory))
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();


        return validator;
    }


}
*/
