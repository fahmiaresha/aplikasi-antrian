package com.example.woe;

public class dataObject {
    String NAMA="", STATUS_DOKTER="";

    public dataObject(String NAMA, String STATUS_DOKTER)
    {
        this.NAMA=NAMA;
        this.STATUS_DOKTER=STATUS_DOKTER;
    }

    public String getNAMA() {
        return NAMA;
    }

    public String getSTATUS_DOKTER() {
        return STATUS_DOKTER;
    }

}
