package specialAnnotation;

import com.myApp.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator  implements ConstraintValidator<PasswordMatchConstraint,UserModel>{
    @Override
    public void initialize(PasswordMatchConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserModel user,
                           ConstraintValidatorContext context) {

        if (user == null)
            return true;

        if (user.getPassword() == null || user.getConfirmPassword() == null)
            return false;

        return user.getPassword().equals(user.getConfirmPassword());
    }
}


