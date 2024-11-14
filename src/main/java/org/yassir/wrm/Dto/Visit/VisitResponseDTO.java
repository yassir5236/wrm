package org.yassir.wrm.Dto.Visit;

import org.yassir.wrm.Dto.Visitor.EmbeddebelVisitorDTO;
import org.yassir.wrm.Dto.WaitingList.EmbeddebelWaitingListDTO;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.embeddeds.VisitKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VisitResponseDTO(
        VisitKey id,

        LocalDateTime arriveTime,

        LocalDateTime startTime,
        LocalDateTime endTime,

        StatusType status,

        int priority,

        int estimatedProcessingTime,

        EmbeddebelVisitorDTO visitor ,
        EmbeddebelWaitingListDTO waitingList

) {
}
