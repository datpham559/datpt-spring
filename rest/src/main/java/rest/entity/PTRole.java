package rest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "role")
public class PTRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code")
    @NotEmpty(message = "Username không được để trống!")
    private String code;

    @Column(name="description")
    @NotEmpty(message = "Username không được để trống!")
    private String description;

}
