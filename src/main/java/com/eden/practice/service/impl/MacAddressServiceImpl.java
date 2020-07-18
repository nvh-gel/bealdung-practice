package com.eden.practice.service.impl;

import com.eden.practice.model.MacAddress;
import com.eden.practice.service.MacAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Service
public class MacAddressServiceImpl implements MacAddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MacAddressServiceImpl.class);

    @Override
    public MacAddress getMacAddress() throws UnknownHostException, SocketException {
        MacAddress macAddress;

        try {
            InetAddress localhost = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localhost);

            macAddress = getMacAddressByInterface(networkInterface);

        } catch (UnknownHostException | SocketException e) {
            Arrays.stream(e.getStackTrace()).forEach(t -> LOGGER.error(String.valueOf(t)));
            throw e;
        }

        return macAddress;
    }

    private MacAddress getMacAddressByInterface(NetworkInterface networkInterface) throws SocketException {
        byte[] hardwareAddress = networkInterface.getHardwareAddress();

        if (hardwareAddress != null) {

            String[] hexadecimal = new String[hardwareAddress.length];
            for (int i = 0; i < hardwareAddress.length; i++) {
                hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
            }
            String address = String.join("-", hexadecimal);
            String name = networkInterface.getName();
            String displayName = networkInterface.getDisplayName();

            return new MacAddress(name, displayName, address);
        }
        return null;
    }

    @Override
    public MacAddress getMacAddressByIp(String ip) throws SocketException, UnknownHostException {
        MacAddress macAddress = null;

        try {
            InetAddress localIp = InetAddress.getByName(ip);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localIp);

            macAddress = getMacAddressByInterface(networkInterface);

        } catch (UnknownHostException | SocketException e) {
            Arrays.stream(e.getStackTrace()).forEach(t -> LOGGER.error(String.valueOf(t)));
            throw e;
        } catch (NullPointerException e) {
            Arrays.stream(e.getStackTrace()).forEach(t -> LOGGER.error(String.valueOf(t)));
        }

        return macAddress;
    }

    @Override
    public List<MacAddress> getAllMacAddresses() throws SocketException {
        List<MacAddress> macAddresses = new ArrayList<>();

        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();

                MacAddress macAddress = this.getMacAddressByInterface(networkInterface);
                if (macAddress != null) {
                    macAddresses.add(macAddress);
                }
            }
        } catch (SocketException e) {
            Arrays.stream(e.getStackTrace()).forEach(t -> LOGGER.error(String.valueOf(t)));
            throw e;
        }

        return macAddresses;
    }
}
