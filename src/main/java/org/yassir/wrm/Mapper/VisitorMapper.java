package org.yassir.wrm.Mapper;


import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.WaitingList;

import java.awt.*;
@Mapper(componentModel = "spring")
public interface VisitorMapper {
//    Visitor toEntityVisitor (VisitorRequestDTO visitorRequestDTO);
//    VisitorRequestDTO toDtoVisitorRequest (Visitor visitor);
//    VisitorResponseDTO toVisitorResponseDTO (Visitor visitor);


    Visitor toEntity (VisitorRequestDTO visitorRequestDTO);
    VisitorResponseDTO toResponseDto (Visitor visitor);
    void updateEntity(VisitorRequestDTO visitorRequestDTO, @MappingTarget Visitor visitor);

}
