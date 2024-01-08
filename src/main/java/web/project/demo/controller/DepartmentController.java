package web.project.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.project.demo.controller.model.DepartmentRequest;
import web.project.demo.controller.model.DepartmentResponse;
import web.project.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping("/create")
    private ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest) throws Exception {
        return ResponseEntity.ok(departmentService.createDepartment(departmentRequest));
    }
}
