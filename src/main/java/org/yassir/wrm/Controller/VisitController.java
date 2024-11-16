package org.yassir.wrm.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.wrm.Dto.Visit.VisitRequestDTO;
import org.yassir.wrm.Dto.Visit.VisitResponseDTO;
import org.yassir.wrm.Service.IVisitService;
import org.yassir.wrm.embeddeds.VisitKey;

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
    public ResponseEntity<VisitResponseDTO> createVisit(@RequestBody VisitRequestDTO visitRequestDTO) {
        VisitResponseDTO createdVisit = visitService.createVisit(visitRequestDTO);
        return new ResponseEntity<>(createdVisit, HttpStatus.CREATED);
    }

    @GetMapping("/{visitKey}")
    public ResponseEntity<VisitResponseDTO> getVisitById(@PathVariable VisitKey visitKey) {
        VisitResponseDTO visit = visitService.getVisitById(visitKey);
        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{visitKey}")
    public ResponseEntity<VisitResponseDTO> updateVisit(
            @PathVariable VisitKey visitKey,
            @Valid @RequestBody VisitRequestDTO visitRequestDTO) {
        VisitResponseDTO updatedVisit = visitService.updateVisit(visitKey, visitRequestDTO);
        return ResponseEntity.ok(updatedVisit);
    }

    @DeleteMapping("/{visitKey}")
    public ResponseEntity<Void> deleteVisit(@PathVariable VisitKey visitKey) {
        visitService.deleteVisit(visitKey);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VisitResponseDTO>> getAllVisits() {
        List<VisitResponseDTO> visits = visitService.getAllVisits();
        return ResponseEntity.ok(visits);
    }

    @PutMapping("/{visitorId}-{waitingListId}/status")
    public ResponseEntity<VisitResponseDTO> updateVisitStatus(
            @PathVariable Long visitorId,
            @PathVariable Long waitingListId,
            @RequestParam String status) {
        VisitResponseDTO updatedVisit = visitService.updateVisitStatus(visitorId, waitingListId, status);
        return ResponseEntity.ok(updatedVisit);
    }
}
