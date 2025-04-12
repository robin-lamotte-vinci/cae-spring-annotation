package be.vinci.ipl.annotation.controllers;

import be.vinci.ipl.annotation.models.dtos.NewUser;
import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

  @Operation(
      summary = "Register a new user",
      description = "Register a new user with provided details "
          + "and return the registration status.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Registration successful"),
          @ApiResponse(responseCode = "400", description = "Registration failed"),
      })
  @PostMapping("/register")
  public void register(@Valid @RequestBody NewUser newUser) {

    User registeredUser = userService.register(newUser);
    if (registeredUser == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration failed");
    }
  }

}