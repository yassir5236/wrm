package org.yassir.wrm.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Repository.VisitRepository;
import org.yassir.wrm.Repository.VisitorRepository;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IVisitService;
import org.yassir.wrm.Mapper.VisitMapper;
import org.yassir.wrm.embeddeds.VisitKey;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImp implements IVisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final VisitorRepository visitorRepository;
    private final WaitingListRepository waitingListRepository;


    @Autowired
    public VisitServiceImp(VisitRepository visitRepository, VisitMapper visitMapper, VisitorRepository visitorRepository, WaitingListRepository waitingListRepository ) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
        this.visitorRepository = visitorRepository;
        this.waitingListRepository = waitingListRepository;
    }


    @Override
    public VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO) {
        Visit visit = visitMapper.toEntity(visitRequestDTO);

        Visitor visitor = visitorRepository.findById(visitRequestDTO.visitorId())
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));

        WaitingList waitingList = waitingListRepository.findById(visitRequestDTO.waitingListId())
                .orElseThrow(() -> new IllegalArgumentException("WaitingList not found"));

        System.out.println("WaitingList fetched: " + waitingList);

        visit.setVisitor(visitor);
        visit.setWaitingList(waitingList);

        System.out.println("Visit entity before saving: " + visit);

        Visit savedVisit = visitRepository.save(visit);
        return visitMapper.toResponseDto(savedVisit);
    }


    @Override
    public VisitResponseDTO getVisitById(VisitKey visitKey) {
        Visit visit = visitRepository.findById(visitKey)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found with key: " + visitKey));
        return visitMapper.toResponseDto(visit);
    }


    @Override
    public List<VisitResponseDTO> getAllVisits() {
        List<Visit> visits = (List<Visit>) visitRepository.findAll();
        return visits.stream()
                .map(visitMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDTO updateVisitStatus(Long visitorId, Long waitingListId, String newStatus) {
        StatusType statusType;
        try {
            statusType = StatusType.valueOf(newStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Statut invalide : " + newStatus);
        }
        WaitingList waintingList = waitingListRepository.findById(waitingListId)
                .orElseThrow(() -> new IllegalArgumentException("WaitingList not found"));

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));

        VisitKey visitKey = new VisitKey(visitorId, waitingListId);

        Visit visit = visitRepository.findById(visitKey)
                .orElseThrow(() -> new IllegalArgumentException("Visite introuvable avec la clé : " + visitKey));

        visit.setStatus(statusType);
        Visit updatedVisit = visitRepository.save(visit);
        return visitMapper.toResponseDto(updatedVisit);
    }


    @Override
    public void deleteVisit(VisitKey visitKey) {
        if (!visitRepository.existsById(visitKey)) {
            throw new IllegalArgumentException("Visit not found with key: " + visitKey);
        }
        visitRepository.deleteById(visitKey);
    }


    @Override
    public VisitResponseDTO updateVisit(VisitKey visitKey, VisitRequestDTO visitRequestDTO) {
        Visit existingVisit = visitRepository.findById(visitKey)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found with key: " + visitKey));

        visitMapper.updateEntity(visitRequestDTO, existingVisit);
        Visit updatedVisit = visitRepository.save(existingVisit);
        return visitMapper.toResponseDto(updatedVisit);
    }
}
