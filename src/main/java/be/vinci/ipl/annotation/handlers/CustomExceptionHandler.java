package be.vinci.ipl.annotation.handlers;

import be.vinci.ipl.annotation.exceptions.UniqueUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * A custom exception handler to manage application-specific exceptions.
 */
@ControllerAdvice
public class CustomExceptionHandler {

  /**
   * Handles the UniqueUsernameException and returns a conflict HTTP status.
   *
   * @param ex the UniqueUsernameException thrown
   * @return a ResponseEntity containing the exception message and HTTP status
   */
  @ExceptionHandler(UniqueUsernameException.class)
  public ResponseEntity<String> handleUniqueUsernameException(UniqueUsernameException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
  }

}