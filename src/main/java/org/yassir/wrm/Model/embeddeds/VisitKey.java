package org.yassir.wrm.Model.embeddeds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record VisitKey(
        @Column(name = "visitor_id") Long visitorId,
        @Column(name = "waitingList_id") Long waitingListId

) {
}

