package be.vinci.ipl.annotation.annotations;

import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate that a username belongs to an existing user of type ADMIN
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAdminCreatorUsername {

  /**
   * Default error message when the username does not belong to an existing user of type ADMIN.
   */
  String message() default "The username does not belong to an existing user of type ADMIN";

  /**
   * Groups for constraint validation.
   */
  Class<?>[] groups() default {};

  /**
   * Payload for clients to specify additional metadata for the constraint.
   */
  Class<? extends Payload>[] payload() default {};
}