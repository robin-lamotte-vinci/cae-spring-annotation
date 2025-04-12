package be.vinci.ipl.annotation.annotations;

import be.vinci.ipl.annotation.models.entities.User.Types;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a user type is valid based on the allowed types.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserType {

  /**
   * Default error message when the user type is invalid.
   */
  String message() default "User type is invalid";

  /**
   * Groups for constraint validation.
   */
  Class<?>[] groups() default {};

  /**
   * Payload for clients to specify additional metadata for the constraint.
   */
  Class<? extends Payload>[] payload() default {};

  /**
   * Allowed user types for validation.
   */
  Types[] allowedTypes() default {};
}