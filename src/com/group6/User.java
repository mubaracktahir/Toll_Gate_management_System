package com.group6;

public class User {
    private String name;
    private String pass;
    private  String email;
    private double totalMoneyPayed;
    private double lastAmountPayed;
    private String dateOfLastPayment;
    private String vehicleName;
    private double amount;
    private String vehocleNumber;
    private String state;
    private int height;
    private String mobileNumber;
    private String idNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVehocleNumber() {
        return vehocleNumber;
    }

    public void setVehocleNumber(String vehocleNumber) {
        this.vehocleNumber = vehocleNumber;
    }

    public String getDateOfLastPayment() {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = dateOfLastPayment;
    }

    public double getLastAmountPayed() {
        return lastAmountPayed;
    }

    public void setLastAmountPayed(Double lastAmountPayed,int requestCode) {
        if(requestCode == 0)
            this.totalMoneyPayed = this.totalMoneyPayed + lastAmountPayed;
        this.lastAmountPayed = lastAmountPayed;
    }

    public double getTotalMoneyPayed() {

        return totalMoneyPayed;
    }

    public void setTotalMoneyPayed(Double totalMoneyPayed) {
        this.totalMoneyPayed = totalMoneyPayed ;
    }
}
