package be.vinci.ipl.annotation.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a unique username constraint is violated.
 */
// @ResponseStatus(HttpStatus.CONFLICT)
public class UniqueUsernameException extends RuntimeException {

  /**
   * Constructs a new UniqueUsernameException with the specified detail message.
   *
   * @param message the detail message explaining the reason for the exception
   */
  public UniqueUsernameException(String message) {
    super(message);
  }
}