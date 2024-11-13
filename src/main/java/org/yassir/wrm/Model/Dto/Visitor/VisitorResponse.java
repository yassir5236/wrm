package org.yassir.wrm.Model.Dto.Visitor;

import java.util.List;

public record VisitorResponse(

        Long id,
        String firstName,
        String lastName,
        List<EmbeddebelVisitor> visitors

) {
}
