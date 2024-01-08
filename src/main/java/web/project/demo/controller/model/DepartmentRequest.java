package web.project.demo.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.project.demo.enums.DepartmentName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    private DepartmentName departmentName;
}
