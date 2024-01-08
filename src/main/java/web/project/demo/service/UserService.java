package web.project.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import web.project.demo.controller.model.DepartmentResponse;
import web.project.demo.controller.model.GetUserResponse;
import web.project.demo.controller.model.UserRequest;
import web.project.demo.controller.model.UserResponse;
import web.project.demo.entity.User;
import web.project.demo.exceptions.UserNotFoundException;
import web.project.demo.repository.DepartmentRepository;
import web.project.demo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private DepartmentService departmentService;

    public GetUserResponse findUser(String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("User doesn't exist");
        }
        User foundUser = user.get();
        return new GetUserResponse(
                foundUser.getUsername(),
                foundUser.getFirstName(),
                foundUser.getLastName(),
                foundUser.getCreatedAt(),
                new DepartmentResponse(foundUser.getDepartment().getId())
        );
    }

    public UserResponse createUser(UserRequest userRequest) throws Exception {
        if (userRequest.getUsername() == null || userRequest.getUsername().isEmpty()) {
            throw new Exception("Username is empty");
        }
        User user = new User(
                userRequest.getUsername(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                departmentService.findDepartment(userRequest.getDepartmentId())

        );
        return new UserResponse(userRepository.save(user).getId());
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(String id, UserRequest userRequest) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " is not found"));
        user.setUsername(userRequest.getUsername());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUpdatedAt(LocalDateTime.now());
        return new UserResponse(userRepository.save(user).getId());
    }
}
