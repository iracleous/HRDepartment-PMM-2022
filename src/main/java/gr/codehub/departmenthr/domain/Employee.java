package gr.codehub.departmenthr.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;

import java.util.List;


/**
 * default fetch type for JPA
 * OneToMany: LAZY
 * ManyToOne: EAGER
 * ManyToMany: LAZY
 * OneToOne: EAGER
 *
 *You shouldn't use CascadeType.ALL on @ManyToOne since entity state transitions should propagate from
 * parent entities to child ones, not the other way around.
 *
 *
 */




@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class Employee extends BaseModel {

	@Column(length = 50, nullable = false, unique = false)
	@NotEmpty
	@NotNull
	private String firstName;

	@Column(length = 50, nullable = false, unique = false)
	@NotEmpty
	@NotNull
	private String lastName;

	@Column(length = 50, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	@Email
	private String email;

	@Column(length = 255, nullable = false, name="pwd")
	@NotNull
	@NotEmpty
	private String password;


	///////////////////////////////////////////////////////////////////
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "employee_position_id")
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "employee_manager_id")
	private Employee manager;

	@OneToMany(mappedBy= "manager",fetch = FetchType.LAZY )
	private List<Employee> supervisorees;


	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "belongs_department_id")
	private Department department;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manages_department_id")
	private Department departmentManagerOf;


	@ManyToMany(fetch = FetchType.LAZY )
	@JoinTable(
			name="USERS_DOCUMENTS",
			joinColumns = @JoinColumn(name="employee_id"),
			inverseJoinColumns = @JoinColumn(name="document_id")
	)
	private List<SignedDocument> documents;


}
