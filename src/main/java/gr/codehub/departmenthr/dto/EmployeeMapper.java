package gr.codehub.departmenthr.dto;

import gr.codehub.departmenthr.domain.Employee;

public class EmployeeMapper {

    public EmployeeDto toEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .password(employee.getPassword())
                .build();
    }

    public Employee toEmployee(EmployeeDto employeeDto){
        Employee employee =    Employee.builder()
                 .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .password(employeeDto.getPassword())
                .build();
        return employee;
    }


}
