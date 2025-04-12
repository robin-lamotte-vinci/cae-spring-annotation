package be.vinci.ipl.annotation.validators;

import be.vinci.ipl.annotation.annotations.ValidAdminCreatorUsername;
import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.models.entities.User.Types;
import be.vinci.ipl.annotation.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Validator to check if a username belongs to an existing user of type ADMIN.
 */
public class AdminCreatorUsernameValidator implements
    ConstraintValidator<ValidAdminCreatorUsername, String> {

  @Autowired
  private UserService userService;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {

    User user = userService.readOneFromUsername(username);

    return user != null && user.getType() == Types.ADMIN;
  }
}