package be.vinci.ipl.annotation.validators;

import be.vinci.ipl.annotation.annotations.ValidUserType;
import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.models.entities.User.Types;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Validator to check if a user type is valid based on the allowed types.
 */
public class UserTypeValidator implements ConstraintValidator<ValidUserType, User.Types> {

  private Types[] allowedTypes;

  @Override
  public void initialize(ValidUserType constraintAnnotation) {
    this.allowedTypes = constraintAnnotation.allowedTypes();
  }

  @Override
  public boolean isValid(Types type, ConstraintValidatorContext context) {
    return Arrays.asList(allowedTypes).contains(type);
  }
}