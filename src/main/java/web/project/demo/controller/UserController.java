package web.project.demo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.project.demo.controller.model.GetUserResponse;
import web.project.demo.controller.model.UserRequest;
import web.project.demo.controller.model.UserResponse;
import web.project.demo.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<GetUserResponse> findUser(@PathVariable(name = "id") String id) throws Exception {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping("/create")
    private ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteUser(@PathVariable(name = "id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<UserResponse> updateUser(
            @PathVariable(name = "id") String id,
            @RequestBody UserRequest userRequest
    ) throws Exception {
        return new ResponseEntity<>(userService.updateUser(id, userRequest), HttpStatus.OK);
    }
}
