package specialAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(ElementType.TYPE) // Because this validation depends on two fields together, so we need it because [ElementType.TYPE] can be placed on a CLASS
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatchConstraint {

    String message() default "Password and Confirm Password do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
