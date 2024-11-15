    package org.yassir.wrm.Mapper;

    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import org.mapstruct.Mappings;
    import org.mapstruct.ReportingPolicy;
    import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
    import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
    import org.yassir.wrm.Model.Entity.WaitingList;

    import java.time.LocalDate;

    import java.time.LocalDateTime;

    @Mapper(componentModel = "spring")
    public interface WaitingListMapper {



        WaitingList toEntity (WaitingListRequestDTO waitingListRequestDTO);
        WaitingListResponseDTO toResponseDto (WaitingList waitingList);

    }
