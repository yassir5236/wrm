package org.yassir.wrm.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.embeddeds.VisitKey;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//
//@Entity
//@Table(name = "visits")
//public class Visit implements Serializable {
//
//    @EmbeddedId
//    private VisitKey id;
//
//    private LocalDateTime arriveTime;
//
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//
//    private StatusType status;
//
//    private int priority;
//
//    private int estimatedProcessingTime;
//
//    @ManyToOne()
//    @MapsId("visitorId")
////    @JoinColumn(name = "visitor_id", nullable = false)
//    Visitor visitor;
//
//    @ManyToOne
//    @MapsId("waitingListId")
////    @JoinColumn(name = "waitingList_id", nullable = false)
//    WaitingList waitingList;
//
//}




@Entity
@Table(name = "visits")
public class Visit implements Serializable {

    @EmbeddedId
    private VisitKey id;

    private LocalDateTime arriveTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private StatusType status;
    private int priority;
    private int estimatedProcessingTime;

//    @ManyToOne
//    @MapsId("visitorId") // Map the visitorId part of the composite key
//    @JoinColumn(name = "visitor_id", nullable = false)
//    private Visitor visitor;
//
//    @ManyToOne
//    @MapsId("waitingListId") // Map the waitingListId part of the composite key
//    @JoinColumn(name = "waitingList_id", nullable = false)
//    private WaitingList waitingList;

    @ManyToOne
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;


    @ManyToOne
    @MapsId("waitingListId")
    @JoinColumn(name = "waiting_list_id")
    private WaitingList waitingList;
}
