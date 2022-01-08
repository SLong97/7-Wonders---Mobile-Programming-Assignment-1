package com.example.thesevenwonders;

public class Wonder {

    String wonderName;
    String wonderLocation;
    String wonderImageURL;
    String wonderInformation;
    String mapCode;

    public Wonder(String wonderName, String wonderLocation, String wonderImageURL, String wonderInformation, String mapCode) {
        this.wonderName = wonderName;
        this.wonderLocation = wonderLocation;
        this.wonderImageURL = wonderImageURL;
        this.wonderInformation = wonderInformation;
        this.mapCode = mapCode;
    }

    public String getWonderName() {
        return wonderName;
    }

    public void setWonderName(String wonderName) {
        this.wonderName = wonderName;
    }

    public String getWonderLocation() {
        return wonderLocation;
    }

    public void setWonderLocation(String wonderLocation) {
        this.wonderLocation = wonderLocation;
    }

    public String getWonderImageURL() {
        return wonderImageURL;
    }

    public void setWonderImageURL(String wonderImageURL) {
        this.wonderImageURL = wonderImageURL;
    }

    public String getWonderInformation() {
        return wonderInformation;
    }

    public void setWonderInformation(String wonderInformation) {
        this.wonderInformation = wonderInformation;
    }

    public String getMapCode() {
        return mapCode;
    }

    public void setMapCode(String mapCode) {
        this.mapCode = mapCode;
    }
}
