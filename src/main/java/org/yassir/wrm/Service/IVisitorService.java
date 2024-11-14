package org.yassir.wrm.Service;

import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;

import java.util.List;

public interface IVisitorService {
    VisitorResponseDTO createVisitor(VisitorRequestDTO visitorRequestDTO);
    VisitorResponseDTO getVisitorById(Long visitorId) ;
    VisitorResponseDTO updateVisitor(Long id, VisitorRequestDTO visitorRequestDTO);
    List<VisitorResponseDTO> getAllVisitors() ;
    void deleteVisitor(Long visitorId);
}
