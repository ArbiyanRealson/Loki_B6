package com.example.testt.models;

public class logbook {
    String status ;
    String tanggal ;
    String panah;

    public logbook() {}

    public logbook(String status, String tanggal, String panah) {
        this.status = status;
        this.tanggal = tanggal;
        this.panah = panah;
    }

    public String  getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPanah() {
        return panah;
    }

    public void setPanah(String panah) {
        this.panah = panah;
    }
}
