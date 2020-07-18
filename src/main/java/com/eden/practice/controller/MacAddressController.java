package com.eden.practice.controller;

import com.eden.practice.model.MacAddress;
import com.eden.practice.service.MacAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping(value = "api/mac-address")
public class MacAddressController {

    @Autowired
    MacAddressService macAddressService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MacAddress>> getAllMacAddresses() throws SocketException {
        return new ResponseEntity<>(macAddressService.getAllMacAddresses(), HttpStatus.OK);
    }

    @GetMapping(value = "/{ip}")
    @ResponseBody
    public ResponseEntity<MacAddress> getMacAddressByIp(@PathVariable(name = "ip") String ip) throws SocketException, UnknownHostException {
        MacAddress macAddress = macAddressService.getMacAddressByIp(ip);

        if (macAddress != null) {
            return new ResponseEntity<>(macAddress, HttpStatus.OK);
        } else {
            macAddress = new MacAddress("", "", "Cannot find the request host.");
            return new ResponseEntity<>(macAddress, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<MacAddress> getMacAddress() throws SocketException, UnknownHostException {
        return new ResponseEntity<>(macAddressService.getMacAddress(), HttpStatus.OK);
    }
}
