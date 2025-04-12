package be.vinci.ipl.annotation.controllers;

import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController to handle user-related requests.
 */
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  /**
   * Constructor for UserController.
   *
   * @param userService the injected UserService.
   */
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * GET requests to retrieve all users.
   *
   * @return an iterable collection of all users
   */
  @Operation(
      summary = "Retrieve all users",
      description = "Fetches a list of all users from the database. "
          + "(User's password and creator shouldn't be provided due to the"
          + " @JsonIgnore on the password's field in User entity)",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Successfully retrieved the list of users"
          ),
      }
  )
  @GetMapping({"", "/"})
  public Iterable<User> getAllUsers() {
    return userService.getAllUsers();
  }

}