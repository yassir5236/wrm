package org.yassir.wrm.Model.Dto.Visit;

import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDate;

public record VisitRequestDTO(


        LocalDate arriveTime,
        LocalDate startTime,
        LocalDate endTime,
        StatusType status,
        int priority,
        int estimatedProcessingTime

) {
}
