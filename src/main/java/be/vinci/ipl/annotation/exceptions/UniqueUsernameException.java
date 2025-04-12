package be.vinci.ipl.annotation.exceptions;

/**
 * Exception thrown when a unique username constraint is violated.
 */
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