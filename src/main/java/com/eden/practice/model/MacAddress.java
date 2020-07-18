package com.eden.practice.model;

public class MacAddress {
    private String name;
    private String displayName;
    private String address;

    public MacAddress(String name, String displayName, String address) {
        this.setName(name);
        this.setDisplayName(displayName);
        this.setAddress(address);
    }

    public MacAddress() {
        this("", "", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
