package web.project.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import web.project.demo.controller.model.DepartmentRequest;
import web.project.demo.controller.model.DepartmentResponse;
import web.project.demo.entity.Department;
import web.project.demo.repository.DepartmentRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) throws Exception{
        if(departmentRequest.getDepartmentName() == null){
            throw new Exception("Username is empty");
        }
        Department department = new Department(
                departmentRequest.getDepartmentName(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return new DepartmentResponse(departmentRepository.save(department).getId());
    }

    public Department findDepartment(String id) throws Exception{
        return departmentRepository.findById(id).orElseThrow(() -> new Exception("Cannot find deparmtnet"));
    }
}
