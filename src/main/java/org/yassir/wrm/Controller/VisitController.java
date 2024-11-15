package org.yassir.wrm.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Service.IVisitService;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private final IVisitService visitService;

    @Autowired
    public VisitController(IVisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<VisitResponseDTO> createVisit( @RequestBody VisitRequestDTO visitRequestDTO) {
        VisitResponseDTO createdVisit = visitService.createVisit(visitRequestDTO);
        return new ResponseEntity<>(createdVisit, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitResponseDTO> getVisitById(@PathVariable Long id) {
        VisitResponseDTO visit = visitService.getVisitById(id);
        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitResponseDTO> updateVisit(
            @PathVariable Long id,
            @Valid @RequestBody VisitRequestDTO visitRequestDTO) {
        VisitResponseDTO updatedVisit = visitService.updateVisit(id, visitRequestDTO);
        return ResponseEntity.ok(updatedVisit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VisitResponseDTO>> getAllVisits() {
        List<VisitResponseDTO> visits = visitService.getAllVisits();
        return ResponseEntity.ok(visits);
    }

//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<VisitResponseDTO>> getVisitsByStatus(@PathVariable String status) {
//        List<VisitResponseDTO> visits = visitService.getVisitsByStatus(status);
//        return ResponseEntity.ok(visits);
//    }
}
