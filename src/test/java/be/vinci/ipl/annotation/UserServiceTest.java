package be.vinci.ipl.annotation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import be.vinci.ipl.annotation.models.entities.User;
import be.vinci.ipl.annotation.models.entities.User.Types;
import be.vinci.ipl.annotation.repositories.UserRepository;
import be.vinci.ipl.annotation.services.UserService;
import java.util.ArrayList;
import java.util.List;
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




}