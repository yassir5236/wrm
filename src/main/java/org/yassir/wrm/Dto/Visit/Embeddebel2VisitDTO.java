package org.yassir.wrm.Dto.Visit;

import org.yassir.wrm.Dto.Visitor.EmbeddebelVisitorDTO;
import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDateTime;

public record Embeddebel2VisitDTO(
        
//        VisitKey id,

        LocalDateTime arriveTime,

        LocalDateTime startTime,
        LocalDateTime endTime,

        StatusType status,

        int priority,

        int estimatedProcessingTime,

        EmbeddebelVisitorDTO visitor

        
        ) {
}
