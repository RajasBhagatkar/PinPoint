package com.pinpoint.PinPoint.controller;

import com.pinpoint.PinPoint.services.StateService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/state")
public class StateInfoController {
    private final StateService stateService;

    /**
     * @param pincode
     * @return Info about that pincode {
     * id: String
     * state: String,
     * division: String,
     * circleName: String,
     * regionName: String,
     * district: String
     * pincode: Integer
     * }[]
     */
    @GetMapping("/{pincode}/info")
    private ResponseEntity getInfoAboutPincode(@PathVariable Integer pincode) {
        return new ResponseEntity(stateService.getStateInfoByPincode(pincode), HttpStatus.OK);
    }

    /**
     * @param state_name
     * @return List Of all Districts In This State
     * [district1, district2,district3,.....]
     */
    @GetMapping("/district/{state_name}")
    private ResponseEntity getAllDistrictOfThisState(@PathVariable String state_name) {
        return new ResponseEntity(stateService.getAllDistrictByStateName(state_name.toUpperCase()), HttpStatus.OK);
    }

    /**
     * @return [state1, state2, state3,.....]
     */
    @GetMapping("/")
    private ResponseEntity getAllStatesOfIndia() {
        return new ResponseEntity(stateService.getAllStatesOfIndia(), HttpStatus.OK);
    }


}
