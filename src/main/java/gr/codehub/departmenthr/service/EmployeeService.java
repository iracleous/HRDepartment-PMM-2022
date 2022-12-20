package gr.codehub.departmenthr.service;

import gr.codehub.departmenthr.domain.Employee;
import gr.codehub.departmenthr.dto.EmployeeDto;
import gr.codehub.departmenthr.exception.ServiceException;

import java.util.List;

public interface EmployeeService {

    void assignManagerToEmployee(long employeeUd, long managerId) throws ServiceException;
    void assignManagerToDepartment(long managerId, long departmentId) throws ServiceException;

    List<EmployeeDto> getAllEmployee();

    EmployeeDto getOneEmployee(long employeeId) throws ServiceException;

    void addEmployee(EmployeeDto employee) throws ServiceException;

}
