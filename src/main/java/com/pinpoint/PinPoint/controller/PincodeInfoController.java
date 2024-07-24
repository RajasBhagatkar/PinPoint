package com.pinpoint.PinPoint.controller;

import com.pinpoint.PinPoint.services.PincodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/pincode")
public class PincodeInfoController {
    private final PincodeService pincodeService;

    @GetMapping("/{pincode}")
    private ResponseEntity getLocalitiesByPincode(@PathVariable Integer pincode) {
        return new ResponseEntity(pincodeService.getLocalitiesFromPincode(pincode), HttpStatus.OK);
    }
}
