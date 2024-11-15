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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImp implements IVisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
       private final VisitorRepository visitorRepository;
       private final WaitingListRepository waitingListRepository;

    @Autowired
    public VisitServiceImp(VisitRepository visitRepository, VisitMapper visitMapper, VisitorRepository visitorRepository, WaitingListRepository waitingListRepository) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
        this.visitorRepository = visitorRepository;
        this.waitingListRepository = waitingListRepository;
    }

//    @Override
//    public VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO) {
//        Visit visit = visitMapper.toEntity(visitRequestDTO);
//        Visit savedVisit = visitRepository.save(visit);
//        return visitMapper.toResponseDto(savedVisit);
//    }

    @Override
    public VisitResponseDTO createVisit(VisitRequestDTO visitRequestDTO) {
        // Convert the DTO to the entity
        Visit visit = visitMapper.toEntity(visitRequestDTO);

        // Fetch the Visitor from the database using visitorId
        Visitor visitor = visitorRepository.findById(visitRequestDTO.visitorId())
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));

        // Fetch the WaitingList from the database using waitingListId
        WaitingList waitingList = waitingListRepository.findById(visitRequestDTO.waitingListId())
                .orElseThrow(() -> new IllegalArgumentException("WaitingList not found"));

        // Debugging: Log or print to confirm the WaitingList is being set
        System.out.println("WaitingList fetched: " + waitingList);

        // Set the visitor and waiting list on the visit entity
        visit.setVisitor(visitor);
        visit.setWaitingList(waitingList);

        // Debugging: Ensure both are set properly
        System.out.println("Visit entity before saving: " + visit);

        // Save the visit entity
        Visit savedVisit = visitRepository.save(visit);

        // Return the response DTO
        return visitMapper.toResponseDto(savedVisit);
    }


    @Override
    public VisitResponseDTO getVisitById(Long visitId) {
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found with ID: " + visitId));
        return visitMapper.toResponseDto(visit);
    }

    @Override
    public VisitResponseDTO updateVisit(Long id, VisitRequestDTO visitRequestDTO) {
        Visit existingVisit = visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found with ID: " + id));

        visitMapper.updateEntity(visitRequestDTO, existingVisit);  // This method updates the entity in place
        Visit updatedVisit = visitRepository.save(existingVisit);
        return visitMapper.toResponseDto(updatedVisit);
    }

    @Override
    public List<VisitResponseDTO> getAllVisits() {
        List<Visit> visits = (List<Visit>) visitRepository.findAll();
        return visits.stream()
                .map(visitMapper::toResponseDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<VisitResponseDTO> getVisitsByStatus(String status) {
//        StatusType statusType = StatusType.valueOf(status.toUpperCase());
//        List<Visit> visits = visitRepository.findByStatus(statusType);
//        return visits.stream()
//                .map(visitMapper::toResponseDto)
//                .collect(Collectors.toList());
//    }


    @Override
    public void deleteVisit(Long visitId) {
        if (!visitRepository.existsById(visitId)) {
            throw new IllegalArgumentException("Visit not found with ID: " + visitId);
        }
        visitRepository.deleteById(visitId);
    }
}
