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
@Table(name = "SIGNED_DOCUMENTS")
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class SignedDocument extends BaseModel{
    @Column(length = 100, nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "documents", fetch = FetchType.LAZY)
    private List<Employee> holders;

}
