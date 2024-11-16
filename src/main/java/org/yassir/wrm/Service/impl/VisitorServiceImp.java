package org.yassir.wrm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Mapper.VisitorMapper;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Repository.VisitorRepository;
import org.yassir.wrm.Repository.VisitorRepository;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IVisitorService;
import org.yassir.wrm.Service.IVisitorService;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.Visitor;
import org.yassir.wrm.Model.Entity.WaitingList;
import org.yassir.wrm.Model.Enum.StatusType;
import org.yassir.wrm.Repository.VisitorRepository;
import org.yassir.wrm.Repository.VisitorRepository;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IVisitorService;
import org.yassir.wrm.Mapper.VisitorMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorServiceImp implements IVisitorService {

    private final VisitorRepository visitorRepository;
    private final VisitorMapper visitorMapper;


    @Autowired
    public VisitorServiceImp(VisitorRepository visitorRepository, VisitorMapper visitorMapper) {
        this.visitorRepository = visitorRepository;
        this.visitorMapper = visitorMapper;

    }



    @Override
    public VisitorResponseDTO createVisitor(VisitorRequestDTO visitorRequestDTO) {
        Visitor visitor = visitorMapper.toEntity(visitorRequestDTO);
        Visitor savedVisitor = visitorRepository.save(visitor);
        return visitorMapper.toResponseDto(savedVisitor);
    }


    @Override
    public VisitorResponseDTO getVisitorById(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found with ID: " + visitorId));
        return visitorMapper.toResponseDto(visitor);
    }

    @Override
    public VisitorResponseDTO updateVisitor(Long id, VisitorRequestDTO visitorRequestDTO) {
        Visitor existingVisitor = visitorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found with ID: " + id));

        visitorMapper.updateEntity(visitorRequestDTO, existingVisitor);
        Visitor updatedVisitor = visitorRepository.save(existingVisitor);
        return visitorMapper.toResponseDto(updatedVisitor);
    }

    @Override
    public List<VisitorResponseDTO> getAllVisitors() {
        List<Visitor> visitors = (List<Visitor>) visitorRepository.findAll();
        return visitors.stream()
                .map(visitorMapper::toResponseDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteVisitor(Long visitorId) {
        if (!visitorRepository.existsById(visitorId)) {
            throw new IllegalArgumentException("Visitor not found with ID: " + visitorId);
        }
        visitorRepository.deleteById(visitorId);
    }
}
