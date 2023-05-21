package rest.validation.customImpl;

import rest.validation.custom.GlobalConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GlobalImpl implements ConstraintValidator<GlobalConstraint, String> {

    @Override
    public void initialize(GlobalConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
