package gr.codehub.departmenthr.controller;

import gr.codehub.departmenthr.domain.Employee;
import gr.codehub.departmenthr.dto.EmployeeDto;
import gr.codehub.departmenthr.exception.ServiceException;
import gr.codehub.departmenthr.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;

    @GetMapping("/")
    public String hello(){
        return "PMM 2022";
    }

    @PutMapping("/employee/{employeeId}/manager/{managerId}")
    public void assignManagerToEmployee(@PathVariable long employeeId, @PathVariable long managerId)
            throws ServiceException {
        service.assignManagerToEmployee(employeeId, managerId);
    }

    @PutMapping("/employeeAsManager/{employeeId}/department/{departmentId}")
    public void assignManagertoDepartment(@PathVariable long employeeId, @PathVariable long departmentId)
            throws ServiceException {
        service.assignManagerToDepartment(employeeId, departmentId);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(){
        return service.getAllEmployee();
    }

}
