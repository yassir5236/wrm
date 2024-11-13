package org.yassir.wrm.Model.Dto.Visit;

import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDate;

public record VisitRequest(


        LocalDate arriveTime,
        LocalDate startTime,
        LocalDate endTime,
        StatusType status,
        int priority,
        int estimatedProcessingTime

) {
}
