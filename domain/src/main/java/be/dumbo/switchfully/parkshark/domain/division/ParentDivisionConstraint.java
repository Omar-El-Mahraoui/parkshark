package be.dumbo.switchfully.parkshark.domain.division;

// copied code from http://www.baeldung.com/spring-mvc-custom-validator

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

public @interface ParentDivisionConstraint {

    @Documented
    @Constraint(validatedBy = ParentDivisionValidator.class)
    @Target( { ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ContactNumberConstraint {
        String message() default "Invalid parent id.";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

}
