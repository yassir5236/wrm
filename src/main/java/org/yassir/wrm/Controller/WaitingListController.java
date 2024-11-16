package org.yassir.wrm.Controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.yassir.wrm.Dto.WaitingList.WaitingListRequestDTO;
import org.yassir.wrm.Dto.WaitingList.WaitingListResponseDTO;
import org.yassir.wrm.Repository.WaitingListRepository;
import org.yassir.wrm.Service.IWaitingListService;

import java.util.List;

@RestController
@RequestMapping("/api/waitingLists")
public class WaitingListController {

    private IWaitingListService waitingListService;
    private WaitingListRepository waitingListRepository;

    @Autowired
    public WaitingListController(IWaitingListService waitingListService, WaitingListRepository waitingListRepository) {
        this.waitingListService = waitingListService;
        this.waitingListRepository = waitingListRepository;
    }


    @PostMapping
    public ResponseEntity<WaitingListResponseDTO> createWaitingList( @RequestBody WaitingListRequestDTO waitingListRequestDTO) {
        WaitingListResponseDTO createdWaitingList = waitingListService.createWaitingList(waitingListRequestDTO);
        return new ResponseEntity<>(createdWaitingList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaitingListResponseDTO> updateWaitingList(
            @PathVariable Long id,
            @Valid @RequestBody WaitingListRequestDTO waitingListRequestDTO
    ) {
        WaitingListResponseDTO updatedWaitingList = waitingListService.updateWaitingList(id, waitingListRequestDTO);
        return ResponseEntity.ok(updatedWaitingList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WaitingListResponseDTO> getSortedWaitingListById(@PathVariable Long id) {
        WaitingListResponseDTO sortedWaitingList = waitingListService.getWaitingListById(id);
        return ResponseEntity.ok(sortedWaitingList);
    }


    @GetMapping
    public ResponseEntity<List<WaitingListResponseDTO>> getAllWaitingLists() {
        List<WaitingListResponseDTO> waitingLists = waitingListService.getAllWaitingLists();
        return ResponseEntity.ok(waitingLists);
    }
}

