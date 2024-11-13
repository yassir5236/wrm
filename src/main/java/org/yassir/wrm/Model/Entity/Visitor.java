package org.yassir.wrm.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "visitors")
public class Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String FirstName;

    private String LastName;

    @OneToMany(mappedBy = "visitor")
    List<Visit> visits;
}
