package org.yassir.wrm.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.WaitingList;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    Visit toEntity (VisitRequestDTO visitRequestDTO);
    VisitResponseDTO toResponseDto (Visit visit);
    void updateEntity(VisitRequestDTO visitRequestDTO, @MappingTarget Visit visit);

}
