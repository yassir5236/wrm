package org.yassir.wrm.Dto.Visit;

import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VisitRequestDTO(


        LocalDateTime arriveTime,
        LocalDateTime startTime,
        LocalDateTime endTime,
        StatusType status,
        int priority,
        int estimatedProcessingTime

) {
}
