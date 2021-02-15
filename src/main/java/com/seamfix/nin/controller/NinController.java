package com.seamfix.nin.controller;

import com.seamfix.nin.dto.RequestDto;
import com.seamfix.nin.dto.ResponseDto;
import com.seamfix.nin.services.NinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinController {
    @Autowired
    NinService ninService;

    @PostMapping(value = "/nin",consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> postNinNumber(@RequestBody RequestDto requestDto) {
            System.out.println("getting the request"+requestDto.getPhoneNumber());
            System.out.println("getting the Nin Number"+requestDto.getNinNumber());
           ResponseDto responseDto= ninService.saveNinNumber(requestDto);
           return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


}
