package org.yassir.wrm.Model.Dto.Visitor;

import org.yassir.wrm.Model.Dto.Visit.EmbeddebelVisitDTO;

import java.util.List;

public record VisitorResponseDTO(

        Long id,
        String firstName,
        String lastName,
        List<EmbeddebelVisitDTO> visits

) {
}
