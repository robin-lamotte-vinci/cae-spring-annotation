package be.vinci.ipl.annotation.services;


import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * User service.
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  /**
   * Constructor.
   *
   * @param userRepository the injected user repository
   */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Retrieves all users from the repository.
   *
   * @return an iterable collection of all users
   */
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}