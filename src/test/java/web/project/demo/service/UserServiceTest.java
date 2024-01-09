package web.project.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import web.project.demo.controller.model.GetUserResponse;
import web.project.demo.entity.Department;
import web.project.demo.entity.User;
import web.project.demo.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    public UserRepository userRepository;
    @Mock
    public DepartmentService departmentService;
    @InjectMocks
    public UserService userService;

    @Test
    @DisplayName(value = "Test if user found is empty")
    public void testIfUserFoundIsNotEmpty() {
        String id = "uuid-random";
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty()); // force it to be this way
        Assertions.assertThrows(Exception.class, () -> userService.findUser(id)); // catch the result that you expect
    }

    @Test
    @DisplayName(value = "Test if findUser is successful")
    public void testIfUserIsSuccessful() throws Exception {
        String id = "random-uuid";
        User user = new User(
                id,
                "username",
                "firstName",
                "lastName",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new Department()
        );

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        GetUserResponse foundUser = userService.findUser(id);
        Mockito.verify(userRepository, Mockito.times(1)).findById(id);
        Assertions.assertEquals(foundUser.getUsername(), user.getUsername());
        Assertions.assertEquals(foundUser.getLastName(), user.getLastName());
        Assertions.assertEquals(foundUser.getFirstName(), user.getFirstName());
    }
}
