package org.yassir.wrm.Model.Dto.Mapper;


import org.yassir.wrm.Model.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Model.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.Visitor;

public interface VisitorMapper {
    Visitor toEntityVisitor (VisitorRequestDTO visitorRequestDTO);
    VisitorRequestDTO toDtoVisitorRequest (Visitor visitor);
    VisitorResponseDTO toVisitorResponseDTO (Visitor visitor);
}
