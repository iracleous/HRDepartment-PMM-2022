package gr.codehub.departmenthr.service;

import gr.codehub.departmenthr.domain.Department;
import gr.codehub.departmenthr.domain.Employee;
import gr.codehub.departmenthr.dto.EmployeeDto;
import gr.codehub.departmenthr.dto.EmployeeMapper;
import gr.codehub.departmenthr.exception.ServiceException;
import gr.codehub.departmenthr.repository.DepartmentRepository;
import gr.codehub.departmenthr.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@EnableCaching
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Override
    @Transactional
    @Cacheable(value="employee", key="#employeeId")
    public void assignManagerToEmployee(long employeeId, long managerId) throws ServiceException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ServiceException("EmployeeNotFound"));
        Employee manager = employeeRepository.findById(managerId)
                .orElseThrow(() -> new ServiceException("ManagerNotFound"));
        employee.setManager(manager);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void assignManagerToDepartment(long managerId, long departmentId) throws ServiceException {
        Employee manager = employeeRepository.findById(managerId)
                .orElseThrow(() -> new ServiceException("ManagerNotFound"));
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ServiceException("DepartmentNotFound"));
        manager.setDepartmentManagerOf(department);
        employeeRepository.save(manager);
    }

    @Override
    @Cacheable(value="employees")
    public List<EmployeeDto> getAllEmployee() {
       try {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      return employeeRepository.findAll().stream()
              .map((e -> new EmployeeMapper().toEmployeeDto(e)))
              .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value="employee", key="#employeeId")
    public EmployeeDto getOneEmployee(long employeeId) throws ServiceException {
       return new EmployeeMapper().toEmployeeDto ( employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ServiceException("EmployeeNotFound")));
    }

    @Override
    @CacheEvict(value="employees")
    @Transactional
    public void addEmployee(EmployeeDto employee) throws ServiceException {
        employeeRepository.save( new    EmployeeMapper().toEmployee(employee));
    }
}
