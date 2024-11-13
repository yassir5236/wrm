package org.yassir.wrm.Model.Service.impl;

import org.yassir.wrm.Model.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Model.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Model.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Model.Dto.WaitingList.WaitingListResponseDTO;

import java.util.List;

public interface IWaitingListService {
    WaitingListResponseDTO createWaitingList(WaitingListRequestDTO waitingListRequestDTO);
    WaitingListResponseDTO getWaitingListById(Long waitingListId) ;
    WaitingListResponseDTO updateWaitingList(Long id, WaitingListRequestDTO waitingListRequestDTO);
    List<WaitingListResponseDTO> getAllWaitingLists() ;
    void deleteWaitingList(Long waitingListId);
}
