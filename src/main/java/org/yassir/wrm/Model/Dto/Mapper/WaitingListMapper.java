package org.yassir.wrm.Model.Dto.Mapper;

import org.yassir.wrm.Model.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Model.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Model.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Model.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.WaitingList;

public interface WaitingListMapper {
    WaitingList toEntityWaitingList (WaitingListRequestDTO waitingListRequestDTO);
    WaitingListRequestDTO toDtoWaitingListRequest (WaitingList waitingList);
    WaitingListResponseDTO toWaitingListResponseDTO (WaitingList waitingList);
}
