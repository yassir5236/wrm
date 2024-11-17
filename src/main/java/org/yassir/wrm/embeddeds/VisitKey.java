package org.yassir.wrm.embeddeds;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.WaitingList;

import java.io.Serializable;



@Embeddable
public record VisitKey(
        @Column(name = "visitor_id") Long visitorId,
        @Column(name = "waiting_list_id") Long waitingListId  // Use consistent column names
) implements Serializable {
}











