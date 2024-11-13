package org.yassir.wrm.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Model.embeddeds.VisitKey;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "visits")
public class Visit implements Serializable {

    @EmbeddedId
    private VisitKey id;

    private LocalDate arriveTime;

    private LocalDate startTime;
    private LocalDate endTime;

    private StatusType status;

    private int priority;

    private int estimatedProcessingTime;

    @ManyToOne()
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id", nullable = false)
    Visitor visitor;

    @ManyToOne
    @MapsId("waitingListId")
    @JoinColumn(name = "waitingList_id", nullable = false)
    WaitingList waitingList;

}