package gr.codehub.departmenthr.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSITIONS")
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class Position extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	private String positionName;

	@Column(length = 20, nullable = false)
	@NotEmpty
	@NotNull
	private String level;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	private List<Employee> employees;

}
