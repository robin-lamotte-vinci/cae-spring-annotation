package be.vinci.ipl.annotation.validators;

import be.vinci.ipl.annotation.annotations.UniqueUsername;
import be.vinci.ipl.annotation.exceptions.UniqueUsernameException;
import be.vinci.ipl.annotation.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Validator to check if a username is unique in the database.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (userRepository.existsByUsername(username)) {
      throw new UniqueUsernameException("Username already exists: " + username);
    }
    return true;
  }

}