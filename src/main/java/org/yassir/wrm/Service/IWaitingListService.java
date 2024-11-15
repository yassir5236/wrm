package org.yassir.wrm.Service;

import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Model.Enum.Algorithm;

import java.util.Comparator;
import java.util.List;

public interface IWaitingListService {
    WaitingListResponseDTO createWaitingList(WaitingListRequestDTO waitingListRequestDTO);
    WaitingListResponseDTO getWaitingListById(Long waitingListId) ;
    WaitingListResponseDTO updateWaitingList(Long id, WaitingListRequestDTO waitingListRequestDTO);
    List<WaitingListResponseDTO> getAllWaitingLists();
    void deleteWaitingList(Long waitingListId);
}
