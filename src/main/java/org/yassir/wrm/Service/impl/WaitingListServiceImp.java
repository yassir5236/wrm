package org.yassir.wrm.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Mapper.WaitingListMapper;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IWaitingListService;
import org.yassir.wrm.config.WaitingListConfig;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WaitingListServiceImp implements IWaitingListService {

    private final WaitingListRepository waitingListRepository;
    private final WaitingListMapper waitingListMapper;
    private final WaitingListConfig waitingListConfig;


    @Autowired
    public WaitingListServiceImp(WaitingListRepository waitingListRepository, WaitingListMapper waitingListMapper, WaitingListConfig waitingListConfig) {
        this.waitingListRepository = waitingListRepository;
        this.waitingListMapper = waitingListMapper;
        this.waitingListConfig = waitingListConfig;
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

        Algorithm algorithm = waitingList.getAlgorithm() != null
                ? waitingList.getAlgorithm()
                : waitingListConfig.getDefaultAlgorithm();

        List<Visit> sortedVisits;
        switch (algorithm) {
            case FIFO:
                sortedVisits = waitingList.getVisits().stream()
                        .sorted(Comparator.comparing(Visit::getArriveTime))
                        .collect(Collectors.toList());
                break;
            case HPS:
                sortedVisits = waitingList.getVisits().stream()
                        .sorted(Comparator.comparing(Visit::getPriority).reversed())
                        .collect(Collectors.toList());
                break;
            case SJF:
                sortedVisits = waitingList.getVisits().stream()
                        .sorted(Comparator.comparing(Visit::getEstimatedProcessingTime))
                        .collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }

        waitingList.setVisits(sortedVisits);

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


    @Override
    public void deleteWaitingList(Long waitingListId) {
        waitingListRepository.deleteById(waitingListId);
    }




    @Override
    public List<WaitingListResponseDTO> getAllWaitingLists() {
        List<WaitingList> waitingLists = StreamSupport
                .stream(waitingListRepository.findAll().spliterator(), false)
                .toList();

        for (WaitingList waitingList : waitingLists) {
            Algorithm algorithm = waitingList.getAlgorithm() != null
                    ? waitingList.getAlgorithm()
                    : waitingListConfig.getDefaultAlgorithm();

            List<Visit> sortedVisits;
            switch (algorithm) {
                case FIFO:
                    sortedVisits = waitingList.getVisits().stream()
                            .sorted(Comparator.comparing(Visit::getArriveTime))
                            .collect(Collectors.toList());
                    break;
                case HPS:
                    sortedVisits = waitingList.getVisits().stream()
                            .sorted(Comparator.comparing(Visit::getPriority).reversed())
                            .collect(Collectors.toList());
                    break;
                case SJF:
                    sortedVisits = waitingList.getVisits().stream()
                            .sorted(Comparator.comparing(Visit::getEstimatedProcessingTime))
                            .collect(Collectors.toList());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
            }

            waitingList.setVisits(sortedVisits);
        }

        return waitingLists.stream()
                .map(waitingListMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}


