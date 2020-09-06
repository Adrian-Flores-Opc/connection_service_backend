package com.api.connection_service_backend.models;

public class GenericRequest {
    private String Canal;
    private String PassCanal;

    public String getCanal() {
        return Canal;
    }

    public void setCanal(String canal) {
        Canal = canal;
    }

    public String getPassCanal() {
        return PassCanal;
    }

    public void setPassCanal(String passCanal) {
        PassCanal = passCanal;
    }
}
