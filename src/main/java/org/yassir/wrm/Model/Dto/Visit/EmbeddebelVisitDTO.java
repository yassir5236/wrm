package org.yassir.wrm.Model.Dto.Visit;

import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Model.embeddeds.VisitKey;

import java.time.LocalDate;

public record EmbeddebelVisitDTO(
        
        VisitKey id,

        LocalDate arriveTime,

        LocalDate startTime,
        LocalDate endTime,

        StatusType status,

        int priority,

        int estimatedProcessingTime
        
        ) {
}
