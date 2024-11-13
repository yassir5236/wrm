package org.yassir.wrm.Model.Service.impl;

import org.yassir.wrm.Model.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Model.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Model.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Model.Dto.Visitor.VisitorResponseDTO;

import java.util.List;

public interface IVisitService {
    VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO);
    VisitResponseDTO getVisitById(Long visitId) ;
    VisitResponseDTO updateVisit(Long id, VisitRequestDTO visitRequestDTO);
    List<VisitResponseDTO> getAllVisits() ;
    void deleteVisit(Long visitId);
}
