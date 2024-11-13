package org.yassir.wrm.Model.Dto.WaitingList;

import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDate;

public record WaitingListRequest(


        LocalDate arriveTime,
        LocalDate startTime,
        LocalDate endTime,
        StatusType status,
        int priority,
        int estimatedProcessingTime

) {
}
