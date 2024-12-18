



package org.yassir.wrm.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "waitingLists")
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date est obligatoire.")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "L'algorithme est obligatoire.")
    private Algorithm algorithm;

    @Min(value = 0, message = "La capacité doit être au moins 0.")
    @Max(value = 100, message = "La capacité ne peut pas dépasser 100.")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le mode est obligatoire.")
    private TypeMode mode;

    @OneToMany(mappedBy = "waitingList", cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();
}
