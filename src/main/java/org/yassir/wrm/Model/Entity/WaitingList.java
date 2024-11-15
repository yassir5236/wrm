package org.yassir.wrm.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Setter
@Getter

//
//@Entity
//@Table(name = "waitingLists")
//
//public class WaitingList implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    private LocalDate date;
//
//    @Enumerated(EnumType.STRING)
//    private Algorithm algorithm;
//
//    private int capacity;
//
//    @Enumerated(EnumType.STRING)
//    private TypeMode mode;
//
//    @OneToMany(mappedBy = "waitingList", cascade = CascadeType.ALL)
//    List<Visit> visits = new ArrayList<>();
//}




@Entity
@Table(name = "waitingLists")
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Algorithm algorithm;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private TypeMode mode;

    @OneToMany(mappedBy = "waitingList", cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();
}
