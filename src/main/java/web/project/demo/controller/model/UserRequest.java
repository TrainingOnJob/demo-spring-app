package web.project.demo.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "First name cannot be null")
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String username;
    private String departmentId;
}
