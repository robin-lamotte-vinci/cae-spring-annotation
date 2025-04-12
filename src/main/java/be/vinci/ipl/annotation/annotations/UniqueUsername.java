package be.vinci.ipl.annotation.annotations;

import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a username is unique.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

  /**
   * Default error message when the email is not unique.
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