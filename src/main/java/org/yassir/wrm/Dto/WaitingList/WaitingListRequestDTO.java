package org.yassir.wrm.Dto.WaitingList;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Model.Enum.TypeMode;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record WaitingListRequestDTO(

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        Algorithm algorithm,
        int capacity,
        TypeMode mode
) {
}
