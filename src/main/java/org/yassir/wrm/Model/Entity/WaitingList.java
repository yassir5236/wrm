package org.yassir.wrm.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "waitingLists")

public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private LocalDate date;

    private String algorithm;

    private int capacity;
    private TypeMode mode;

    @OneToMany(mappedBy = "waitingList")
    List<Visit> visits;
}
