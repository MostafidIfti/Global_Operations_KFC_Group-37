package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

public class Staff extends User{

    private String stationAssigned = "Unassigned";

    public Staff(int id, String name) {
        super(id, name);
    }

    public String getStationAssigned() {
        return stationAssigned;
    }

    public void setStationAssigned(String stationAssigned) {
        this.stationAssigned = stationAssigned;
    }

}
