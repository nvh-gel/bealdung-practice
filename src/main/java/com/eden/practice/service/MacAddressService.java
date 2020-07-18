package com.eden.practice.service;

import com.eden.practice.model.MacAddress;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public interface MacAddressService {
    MacAddress getMacAddress() throws UnknownHostException, SocketException;

    MacAddress getMacAddressByIp(String ip) throws SocketException, UnknownHostException;

    List<MacAddress> getAllMacAddresses() throws SocketException;
}
