package org.yassir.wrm.Model.Dto.Visitor;

import org.yassir.wrm.Model.Enum.StatusType;

import java.time.LocalDate;

public record VisitorRequest(


        String firstName,
        String lastName

) {
}
