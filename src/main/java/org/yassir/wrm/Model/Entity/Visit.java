//package org.yassir.wrm.Model.Entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.*;
//import org.yassir.wrm.Model.Enum.StatusType;
//import org.yassir.wrm.embeddeds.VisitKey;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//
//@Entity
//@Table(name = "visits")
//public class Visit implements Serializable {
//
//    @EmbeddedId
//    private VisitKey id;
//
//    private LocalDateTime arriveTime;
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//
//    private StatusType status;
//    private int priority;
//    private int estimatedProcessingTime;
//
////    @ManyToOne
////    @MapsId("visitorId") // Map the visitorId part of the composite key
////    @JoinColumn(name = "visitor_id", nullable = false)
////    private Visitor visitor;
////
////    @ManyToOne
////    @MapsId("waitingListId") // Map the waitingListId part of the composite key
////    @JoinColumn(name = "waitingList_id", nullable = false)
////    private WaitingList waitingList;
//
//    @ManyToOne
//    @MapsId("visitorId")
//    @JoinColumn(name = "visitor_id")
//    private Visitor visitor;
//
//
//    @ManyToOne
//    @MapsId("waitingListId")
//    @JoinColumn(name = "waiting_list_id")
//    private WaitingList waitingList;
//}



package org.yassir.wrm.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.embeddeds.VisitKey;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "visits")
public class Visit implements Serializable {

    @EmbeddedId
    private VisitKey id;

    @NotNull(message = "L'heure d'arrivée est obligatoire.")
    @PastOrPresent(message = "L'heure d'arrivée doit être dans le passé ou le présent.")
    private LocalDateTime arriveTime;

    @FutureOrPresent(message = "L'heure de début doit être dans le présent ou le futur.")
    private LocalDateTime startTime;

    @FutureOrPresent(message = "L'heure de fin doit être dans le présent ou le futur.")
    private LocalDateTime endTime;

    @NotNull(message = "Le statut est obligatoire.")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Min(value = 1, message = "La priorité doit être au moins 1.")
    @Max(value = 10, message = "La priorité ne peut pas dépasser 10.")
    private int priority;

    @Min(value = 1, message = "Le temps estimé de traitement doit être au moins 1 minute.")
    private int estimatedProcessingTime;

    @ManyToOne
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id", nullable = false)
    @NotNull(message = "Le visiteur est obligatoire.")
    private Visitor visitor;

    @ManyToOne
    @MapsId("waitingListId")
    @JoinColumn(name = "waiting_list_id", nullable = false)
    @NotNull(message = "La liste d'attente est obligatoire.")
    private WaitingList waitingList;
}
