package com.pinpoint.PinPoint.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinpoint.PinPoint.services.PincodeService;
import com.pinpoint.PinPoint.services.StateService;
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
    private final StateService stateService;

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    /**
     *
     * @param pincode
     * @return {
     * "pincode" : Integer,
     * "locality" : String | null,
     * "state" : String | null,
     * "latitude" : Double ,
     * "longitude" : Double
     * }[]
     */
    @GetMapping("/{pincode}")
    private ResponseEntity getLocalitiesByPincode(@PathVariable Integer pincode) {
        return new ResponseEntity(pincodeService.getLocalitiesFromPincode(pincode), HttpStatus.OK);
    }

    /**
     *
     * @param pincode
     * @return {district: String}
     */
    @GetMapping("/{pincode}/district")
    private ResponseEntity getDistrictOfPincode(@PathVariable Integer pincode){
        String district_result = stateService.getDistrictOfPincode(pincode);

        Object response = new Object(){
            String district = district_result;
        };
        JsonNode responseJson = mapper.valueToTree(response);
        return new ResponseEntity(responseJson, HttpStatus.OK);
    }

    /**
     *
     * @param pincode
     * @return {state: String}
     */
    @GetMapping("/{pincode}/state")
    private ResponseEntity getStateOfPincode(@PathVariable Integer pincode) {
        String state_result = stateService.getStateOfPincode(pincode);

        Object response = new Object(){
            String state = state_result;
        };

        JsonNode responseJson = mapper.valueToTree(response);

        return new ResponseEntity(responseJson, HttpStatus.OK);
    }
}
