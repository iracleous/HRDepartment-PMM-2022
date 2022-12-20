package gr.codehub.departmenthr.repository;


import gr.codehub.departmenthr.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findById(Long id);

	List<Employee> findAllByDepartmentId(Long departmentId);

	List<Employee> findUsersByManagerId(Long managerId);

	List<Employee> findUsersByFirstNameOrLastNameLikeIgnoreCase(String firstName, String lastName);

	Employee findByEmail(String email);

	List<Employee> findUsersByPositionId(Long positionId);


}
