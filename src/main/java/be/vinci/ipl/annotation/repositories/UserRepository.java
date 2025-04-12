package be.vinci.ipl.annotation.repositories;

import be.vinci.ipl.annotation.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * Check if a user exists by username.
   *
   * @param username the username to check
   * @return true if a user with this username exists
   */
  boolean existsByUsername(String username);

  /**
   * Find a user by its username.
   *
   * @param username the username
   * @return the user if exists, null otherwise
   */
  User findByUsername(String username);
}
