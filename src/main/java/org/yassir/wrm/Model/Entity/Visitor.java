package org.yassir.wrm.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


@Entity
@Table(name = "visitors")
public class Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="First Name required")
    private String firstName;

    @NotBlank(message ="LastName Name required")
    private String lastName;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)

    private List<Visit> visits = new ArrayList<>();
}
