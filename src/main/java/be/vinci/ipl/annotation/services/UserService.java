package be.vinci.ipl.annotation.services;


import be.vinci.ipl.annotation.models.dtos.NewUser;
import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.models.entities.User.Types;
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

  /**
   * Register a new user.
   *
   * @param newUser the new user to register (assuming he is valid)
   * @return registered User when the registration is successful, null otherwise
   */
  public User register(NewUser newUser) {
    String username = newUser.getUsername();
    // registration fail if username already exists
    if (userRepository.existsByUsername(username)) {
      return null;
    }

    User creator = userRepository.findByUsername(newUser.getCreatorUsername());
    // registration should if creatorUsername isn't the username of an existing user of type admin
    if (creator == null || creator.getType() != Types.ADMIN) {
      return null;
    }

    User user = new User();
    user.setUsername(newUser.getUsername());
    user.setPassword(newUser.getPassword());
    user.setCreator(creator);
    user.setType(newUser.getType());

    return userRepository.save(user);
  }
}