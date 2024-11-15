package org.yassir.wrm.Dto.WaitingList;

import org.yassir.wrm.Dto.Visit.Embeddebel2VisitDTO;
import org.yassir.wrm.Dto.Visit.EmbeddebelVisitDTO;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record WaitingListResponseDTO(

        Long id,
        LocalDate date,
        Algorithm algorithm,
        int capacity,
        TypeMode mode,
        List<Embeddebel2VisitDTO> visits
) {
}
