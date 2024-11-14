package org.yassir.wrm.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "waitingLists")

public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private LocalDateTime date;

    private Algorithm algorithm;

    private int capacity;
    private TypeMode mode;

    @OneToMany(mappedBy = "waitingList", cascade = CascadeType.ALL)
    List<Visit> visits = new ArrayList<>();
}
