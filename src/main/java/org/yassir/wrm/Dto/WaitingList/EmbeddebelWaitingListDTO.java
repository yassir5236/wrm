package org.yassir.wrm.Dto.WaitingList;

import org.yassir.wrm.Dto.Visit.EmbeddebelVisitDTO;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmbeddebelWaitingListDTO(

        Long id,

        LocalDateTime date,

        Algorithm algorithm,

        int capacity,
        TypeMode mode

) {
}
