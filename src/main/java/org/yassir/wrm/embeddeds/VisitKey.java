package org.yassir.wrm.embeddeds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Embeddable
public record VisitKey(
        @Column(name = "visitor_id") Long visitorId,
        @Column(name = "waiting_list_id") Long waitingListId  // Use consistent column names
) implements Serializable {
}


//@Embeddable
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class VisitKey implements Serializable{
//    Long visitorId;
//    Long waitingListId;
//}









