package org.yassir.wrm.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.wrm.Dto.Visitor.VisitorRequestDTO;
import org.yassir.wrm.Dto.Visitor.VisitorResponseDTO;
import org.yassir.wrm.Service.IVisitorService;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final IVisitorService visitorService;

    @Autowired
    public VisitorController(IVisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<VisitorResponseDTO> createVisitor(@Valid @RequestBody VisitorRequestDTO visitorRequestDTO) {
        VisitorResponseDTO createdVisitor = visitorService.createVisitor(visitorRequestDTO);
        return new ResponseEntity<>(createdVisitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitorResponseDTO> getVisitorById(@PathVariable Long id) {
        VisitorResponseDTO visitor = visitorService.getVisitorById(id);
        return ResponseEntity.ok(visitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitorResponseDTO> updateVisitor(
            @PathVariable Long id,
            @Valid @RequestBody VisitorRequestDTO visitorRequestDTO) {
        VisitorResponseDTO updatedVisitor = visitorService.updateVisitor(id, visitorRequestDTO);
        return ResponseEntity.ok(updatedVisitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VisitorResponseDTO>> getAllVisitors() {
        List<VisitorResponseDTO> visitors = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitors);
    }




}
