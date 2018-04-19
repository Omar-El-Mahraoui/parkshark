/*
package be.dumbo.switchfully.parkshark.domain.division;

// copied code from http://www.baeldung.com/spring-mvc-custom-validator, javavids spring web app tutorial

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = parentDivisionIdValidator.class)
public @interface parentDivisionIdConstraint {

    String message() default "Invalid parent id.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
*/
