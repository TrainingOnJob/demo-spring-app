package web.project.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.project.demo.enums.DepartmentName;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private DepartmentName departmentName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private List<User> departments;

    public Department(DepartmentName departmentName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.departmentName = departmentName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
