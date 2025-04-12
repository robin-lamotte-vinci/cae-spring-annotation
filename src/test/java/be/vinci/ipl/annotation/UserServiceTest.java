package be.vinci.ipl.annotation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import be.vinci.ipl.annotation.models.dtos.NewUser;
import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.models.entities.User.Types;
import be.vinci.ipl.annotation.repositories.UserRepository;
import be.vinci.ipl.annotation.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	private NewUser newUser;
	private User user;

	@BeforeEach
	void setUp() {
		newUser = new NewUser();
		newUser.setUsername("Erwin");
		newUser.setPassword("Schrodinger'sCat");
		newUser.setCreatorUsername("Isaac");
		newUser.setType(Types.USER);

		User creator = new User(); // should be completed with coherent data
		creator.setUsername(newUser.getCreatorUsername());
		creator.setType(Types.ADMIN);


		user = new User();
		user.setUsername(newUser.getUsername());
		user.setPassword(newUser.getPassword());
		user.setCreator(creator);
		user.setType(newUser.getType());
	}

	@Test
	void testGetAllUsers() {
		// Arrange
		List<User> fakeUsersList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			User fakeUser = new User();
			fakeUser.setId((long) i);
			fakeUser.setUsername("UserN" + i);
			fakeUser.setPassword("password");
			fakeUser.setType(Types.ADMIN);
			fakeUsersList.add(fakeUser);
		}

		when(userRepository.findAll()).thenReturn(fakeUsersList);

		// Act
		Iterable<User> result = userService.getAllUsers();

		// Assert
		assertEquals(fakeUsersList, result,
				"The returned user list does not match the expected list.");
	}

	@Test
	void testRegisterWithValidData() {
		// Arrange
		when(userRepository.existsByUsername(newUser.getUsername())).thenReturn(false);
		when(userRepository.findByUsername(newUser.getCreatorUsername())).thenReturn(user.getCreator());
		when(userRepository.save(any(User.class))).thenReturn(user);

		// Act
		User result = userService.register(newUser);

		// Assert
		assertNotNull(result,
				"Register a user with valid data should return an User instance.");
	}

	@Test
	void testRegisterWithExistingUsername() {
		// Arrange
		when(userRepository.existsByUsername(newUser.getUsername())).thenReturn(true);

		// Act
		User result = userService.register(newUser);

		// Assert
		assertNull(result,
				"Register a user with existing username should return null.");
	}

	@Test
	void testRegisterWithUnknownCreatorUser() {
		// Arrange
		when(userRepository.existsByUsername(newUser.getUsername())).thenReturn(false);
		when(userRepository.findByUsername(newUser.getCreatorUsername())).thenReturn(null);

		// Act
		User result = userService.register(newUser);

		// Assert
		assertNull(result,
				"Register a user with unknown creator user should return null.");
	}

	@Test
	void testRegisterWithNonAdminCreator() {
		// Arrange
		when(userRepository.existsByUsername(newUser.getUsername())).thenReturn(false);
		when(userRepository.findByUsername(newUser.getCreatorUsername())).thenReturn(user);

		// Act
		User result = userService.register(newUser);

		// Assert
		assertNull(result,
				"Register a user with non admin creator user should return null.");
	}


}