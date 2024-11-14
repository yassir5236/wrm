package org.yassir.wrm.Dto.Visitor;

import org.yassir.wrm.Dto.Visit.EmbeddebelVisitDTO;

import java.util.List;

public record VisitorResponseDTO(

        Long id,
        String firstName,
        String lastName,
        List<EmbeddebelVisitDTO> visits

) {
}
