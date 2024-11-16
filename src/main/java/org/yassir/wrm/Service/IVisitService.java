package org.yassir.wrm.Service;

import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.embeddeds.VisitKey;

import java.util.List;

public interface IVisitService {
    VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO);

    VisitResponseDTO getVisitById(VisitKey visitKey);

    VisitResponseDTO updateVisit(VisitKey visitKey, VisitRequestDTO visitRequestDTO);

    List<VisitResponseDTO> getAllVisits();

    void deleteVisit(VisitKey visitKey);

    VisitResponseDTO updateVisitStatus(Long visitorId, Long waitingListId, String newStatus);
}
