package org.yassir.wrm.Model.Service.impl;

import org.yassir.wrm.Model.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Model.Dto.Visitor.VisitorResponseDTO;

import java.util.List;

public interface IVisitorService {
    VisitorResponseDTO createVisitor(VisitorRequestDTO visitorRequestDTO);
    VisitorResponseDTO getVisitorById(Long visitorId) ;
    VisitorResponseDTO updateVisitor(Long id, VisitorRequestDTO visitorRequestDTO);
    List<VisitorResponseDTO> getAllVisitors() ;
    void deleteVisitor(Long visitorId);
}
