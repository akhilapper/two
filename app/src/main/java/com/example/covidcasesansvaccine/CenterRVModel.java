package com.example.covidcasesansvaccine;

public class CenterRVModel {
    private final String centerName;

    private final String centerAddress;

    private final String centerFromTime;

    private final String centerToTime;

    private String fee_type;
    private int ageLimit;

    private String vaccineName;
    private int availableCapacity;

    public CenterRVModel(String centerName, String centerAddress, String centerFromTime, String centerToTime, String fee_type, int ageLimit, String vaccineName, int avaliableCapacity) {
        this.centerName = centerName;
        this.centerAddress = centerAddress;
        this.centerFromTime = centerFromTime;
        this.centerToTime = centerToTime;
    }


    public final String getCenterName() {
        return this.centerName;
    }


    public final String getCenterAddress() {
        return this.centerAddress;
    }


    public final String getCenterFromTime() {
        return this.centerFromTime;
    }


    public final String getCenterToTime() {
        return this.centerToTime;
    }


    public final String getFee_type() {
        return this.fee_type;
    }

    public final void setFee_type( String var1) {

        this.fee_type = var1;
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    public final void setAgeLimit(int var1) {
        this.ageLimit = var1;
    }


    public final String getVaccineName() {
        return this.vaccineName;
    }

    public final void setVaccineName( String var1) {

        this.vaccineName = var1;
    }

    public final int getAvailableCapacity() {
        return this.availableCapacity;
    }

    public final void setAvailableCapacity(int var1) {
        this.availableCapacity = var1;
    }
}
