package com.pinpoint.PinPoint.controller;

import com.pinpoint.PinPoint.entity.StateInfoEntity;
import com.pinpoint.PinPoint.repository.StateInfoRepository;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class testController {
    private final StateInfoRepository stateInfoRepository;

    @GetMapping("/insertData")
    private ResponseEntity<?> insertDB() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
