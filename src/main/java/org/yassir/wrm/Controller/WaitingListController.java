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
    public ResponseEntity<WaitingListResponseDTO> getWaitingListById(@PathVariable Long id) {
        WaitingListResponseDTO waitingListResponseDTO = waitingListService.getWaitingListById(id);
        return ResponseEntity.ok(waitingListResponseDTO);
    }


    @GetMapping
    public ResponseEntity<List<WaitingListResponseDTO>> getAllWaitingLists() {
        List<WaitingListResponseDTO> waitingLists = waitingListService.getAllWaitingLists();
        return ResponseEntity.ok(waitingLists);
    }
}


//
//@RestController
//@RequestMapping("/api/owners")
//@Validated
//public class WaitingListController {
//
//    private final WaitingListRepository ownerRepository;
//    private IWaitingListService ownerService;
//
//    @Autowired
//    public WaitingListController(IWaitingListService ownerService, WaitingListRepository ownerRepository) {
//        this.ownerService = ownerService;
//        this.ownerRepository = ownerRepository;
//    }
//
//
//
//    @PostMapping
//    public ResponseEntity<WaitingListResponse> createWaitingList(@Valid @RequestBody WaitingListRequest ownerRequest) {
//        WaitingListResponse createdWaitingList = ownerService.createWaitingList(ownerRequest);
//        return new ResponseEntity<>(createdWaitingList, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<WaitingListResponse> getWaitingListById(@IdExist(message = "owner noooot found") @PathVariable Long id) {
//        WaitingListResponse ownerResponse = ownerService.getWaitingListById(id);
//        return ResponseEntity.ok(ownerResponse);
//    }
//

//
//    @GetMapping
//    public ResponseEntity<List<WaitingListResponse>> getAllWaitingLists() {
//        List<WaitingListResponse> owners = ownerService.getAllWaitingLists();
//        return ResponseEntity.ok(owners);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<WaitingListResponse> deleteWaitingList(@IdExist(message = "owner introvable with this id") @PathVariable Long id) {
//        ownerService.deleteWaitingList(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        StringBuilder errors = new StringBuilder();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
//        });
//        return ResponseEntity.badRequest().body(errors.toString());
//    }
//
//
//
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
//        String errorMessage = ex.getConstraintViolations().stream()
//                .map(violation -> violation.getMessage())
//                .findFirst()
//                .orElse("Erreur de validation");
//
//        return ResponseEntity.badRequest().body(errorMessage);
//    }
//
//
//}
//
