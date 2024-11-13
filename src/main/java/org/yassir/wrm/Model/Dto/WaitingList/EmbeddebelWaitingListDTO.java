package org.yassir.wrm.Model.Dto.WaitingList;

import org.yassir.wrm.Model.Dto.Visit.EmbeddebelVisitDTO;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.time.LocalDate;
import java.util.List;

public record EmbeddebelWaitingListDTO(

        Long id,

        LocalDate date,

        String algorithm,

        int capacity,
        TypeMode mode,

        List<EmbeddebelVisitDTO> visits
) {
}
