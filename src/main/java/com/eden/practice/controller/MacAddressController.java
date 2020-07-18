package com.eden.practice.controller;

import com.eden.practice.model.MacAddress;
import com.eden.practice.service.MacAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/mac-address")
public class MacAddressController {

    @Autowired
    MacAddressService macAddressService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<MacAddress> getMacAddress() {
        return new ResponseEntity<>(macAddressService.getMacAddress(), HttpStatus.OK);
    }
}
