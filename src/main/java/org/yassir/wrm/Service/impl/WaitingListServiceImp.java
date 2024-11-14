package org.yassir.wrm.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Mapper.WaitingListMapper;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IWaitingListService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaitingListServiceImp implements IWaitingListService {

    private final WaitingListRepository waitingListRepository;
    private final WaitingListMapper waitingListMapper;

    @Autowired
    public WaitingListServiceImp(WaitingListRepository waitingListRepository, WaitingListMapper waitingListMapper) {
        this.waitingListRepository = waitingListRepository;
        this.waitingListMapper = waitingListMapper;
    }

    @Override
    public WaitingListResponseDTO createWaitingList(WaitingListRequestDTO waitingListRequestDTO) {
        WaitingList waitingList = waitingListMapper.toEntity(waitingListRequestDTO);
        System.out.println(waitingListRequestDTO);
        System.out.println(waitingList);
        WaitingList savedWaitingList = waitingListRepository.save(waitingList);
        return waitingListMapper.toResponseDto(savedWaitingList);
    }

    @Override
    public WaitingListResponseDTO getWaitingListById(Long waitingListId) {
        WaitingList waitingList = waitingListRepository.findById(waitingListId)
                .orElseThrow(() -> new RuntimeException("Waiting list not found with ID: " + waitingListId));
        return waitingListMapper.toResponseDto(waitingList);
    }

    @Override
    public WaitingListResponseDTO updateWaitingList(Long id, WaitingListRequestDTO waitingListRequestDTO) {
        WaitingList existingWaitingList = waitingListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waiting list not found with ID: " + id));
        WaitingList updatedWaitingList = waitingListMapper.toEntity(waitingListRequestDTO);
//        updatedWaitingList.setId(existingWaitingList.getId());
        WaitingList savedUpdatedList = waitingListRepository.save(updatedWaitingList);
        return waitingListMapper.toResponseDto(savedUpdatedList);
    }
//
//    @Override
//    public List<WaitingListResponseDTO> getAllWaitingLists() {
//        List<WaitingList> waitingLists = waitingListRepository.findAll();
//        return waitingLists.stream()
//                .map(waitingListMapper::toResponseDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteWaitingList(Long waitingListId) {
        waitingListRepository.deleteById(waitingListId);
    }
}
