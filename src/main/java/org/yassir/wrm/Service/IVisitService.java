package org.yassir.wrm.Service;

import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;

import java.util.List;

public interface IVisitService {
    VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO);
    VisitResponseDTO getVisitById(Long visitId) ;
    VisitResponseDTO updateVisit(Long id, VisitRequestDTO visitRequestDTO);
    List<VisitResponseDTO> getAllVisits() ;
    void deleteVisit(Long visitId);
}
