package org.yassir.wrm.Model.Dto.Visit;

import org.yassir.wrm.Model.Dto.Visitor.EmbeddebelVisitorDTO;
import org.yassir.wrm.Model.Dto.WaitingList.EmbeddebelWaitingListDTO;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Model.embeddeds.VisitKey;

import java.time.LocalDate;

public record VisitResponseDTO(
        VisitKey id,

        LocalDate arriveTime,

        LocalDate startTime,
        LocalDate endTime,

        StatusType status,

        int priority,

        int estimatedProcessingTime,

        EmbeddebelVisitorDTO visitor ,
        EmbeddebelWaitingListDTO waitingList

) {
}
