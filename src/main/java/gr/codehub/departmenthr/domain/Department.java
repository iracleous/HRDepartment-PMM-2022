package gr.codehub.departmenthr.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENTS")
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class Department extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
 	@JoinColumn(name = "manager_id")
	private Employee headOfDepartment;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private List<Employee> members;
}
