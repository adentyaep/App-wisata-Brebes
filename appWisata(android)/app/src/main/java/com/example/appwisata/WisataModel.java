package com.example.appwisata;

public class WisataModel {
    private String nama_wisata;
    private String lokasiWisata;
    private String gambarWisata;
    private String deskripsi;
    private String longitude;
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getLokasiWisata() {
        return lokasiWisata;
    }

    public void setLokasiWisata(String lokasiWisata) {
        this.lokasiWisata = lokasiWisata;
    }

    public String getGambarWisata() {
        return gambarWisata;
    }

    public void setGambarWisata(String gambarWisata) {
        this.gambarWisata = gambarWisata;
    }
}
