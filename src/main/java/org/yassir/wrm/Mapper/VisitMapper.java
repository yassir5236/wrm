package org.yassir.wrm.Mapper;

import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;

public interface VisitMapper {
    Visit toEntityVisit (VisitRequestDTO visitRequestDTO);
    VisitRequestDTO toDtoVisitRequest (Visit visit);
    VisitResponseDTO toVisitResponseDTO (Visit visit);

}
