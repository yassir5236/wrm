package org.yassir.wrm.Mapper;


import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Model.Entity.Visitor;

public interface VisitorMapper {
    Visitor toEntityVisitor (VisitorRequestDTO visitorRequestDTO);
    VisitorRequestDTO toDtoVisitorRequest (Visitor visitor);
    VisitorResponseDTO toVisitorResponseDTO (Visitor visitor);
}
