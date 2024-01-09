package web.project.demo.controller.model;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private DepartmentResponse departmentResponse;
}
