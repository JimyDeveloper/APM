package com;

import java.sql.Date;

public class Registration {
    
    private String department;
    private String station;
    private String object;
    private int leftDays;
    private String detail;
    private Date lastCheck;
    private Date nextCheck;
    private int location;
    private int registrationID;
    
    private int warranty;
    private String name;
    
    public Registration() {}
    
    public Registration(String name) {
        this.name = name;
    }

    
    public Registration(String name, int warranty) {
        this.name = name;
        this.warranty = warranty;
    }

    
    public Registration(String department, String station, String object, 
            int leftDays, String detail, Date lastCheck, Date nextCheck,
            int location, int detailCode) {
        this.department = department;
        this.station = station;
        this.object = object;
        this.leftDays = leftDays;
        this.detail = detail;
        this.lastCheck = lastCheck;
        this.nextCheck = nextCheck;
        this.location = location;
        this.registrationID = detailCode;
    }    

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getLeftDays() {
        return leftDays;
    }

    public void setLeftDays(int leftDays) {
        this.leftDays = leftDays;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    public Date getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(Date nextCheck) {
        this.nextCheck = nextCheck;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    @Override
    public String toString() {
        return "Registration{" + "department=" + department + ", station=" + station + ", object=" + object + ", leftDays=" + leftDays + ", detail=" + detail + ", lastCheck=" + lastCheck + ", nextCheck=" + nextCheck + ", location=" + location + ", detailCode=" + registrationID + '}';
    }

    
}