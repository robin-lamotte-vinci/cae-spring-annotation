package be.vinci.ipl.annotation.annotations;

import be.vinci.ipl.annotation.validators.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a username is unique.
 */
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

  /**
   * Default error message when the username is not unique.
   */
  String message() default "Username must be unique";

  /**
   * Groups for constraint validation.
   */
  Class<?>[] groups() default {};

  /**
   * Payload for clients to specify additional metadata for the constraint.
   */
  Class<? extends Payload>[] payload() default {};
}