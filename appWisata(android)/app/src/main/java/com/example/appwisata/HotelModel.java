package com.example.appwisata;

import android.os.Parcel;
import android.os.Parcelable;

public class HotelModel implements Parcelable {
    private String nama_hotel;
    private String lokasiHotel;
    private String gambarHotel;
    private String latitudeHotel;
    private String longitudeHotel;

    public String getDeskripsiHotel() {
        return deskripsiHotel;
    }

    public void setDeskripsiHotel(String deskripsiHotel) {
        this.deskripsiHotel = deskripsiHotel;
    }

    private String deskripsiHotel;

    public String getNama_hotel() {
        return nama_hotel;
    }

    public void setNama_hotel(String nama_hotel) {
        this.nama_hotel = nama_hotel;
    }

    public String getLokasiHotel() {
        return lokasiHotel;
    }

    public void setLokasiHotel(String lokasiHotel) {
        this.lokasiHotel = lokasiHotel;
    }

    public String getGambarHotel() {
        return gambarHotel;
    }

    public void setGambarHotel(String gambarHotel) {
        this.gambarHotel = gambarHotel;
    }

    public String getLatitudeHotel() {
        return latitudeHotel;
    }

    public void setLatitudeHotel(String latitudeHotel) {
        this.latitudeHotel = latitudeHotel;
    }

    public String getLongitudeHotel() {
        return longitudeHotel;
    }

    public void setLongitudeHotel(String longitudeHotel) {
        this.longitudeHotel = longitudeHotel;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_hotel);
        dest.writeString(this.lokasiHotel);
        dest.writeString(this.gambarHotel);
        dest.writeString(this.latitudeHotel);
        dest.writeString(this.longitudeHotel);
        dest.writeString(this.deskripsiHotel);
    }

    public void readFromParcel(Parcel source) {
        this.nama_hotel = source.readString();
        this.lokasiHotel = source.readString();
        this.gambarHotel = source.readString();
        this.latitudeHotel = source.readString();
        this.longitudeHotel = source.readString();
        this.deskripsiHotel = source.readString();
    }

    public HotelModel() {
    }

    protected HotelModel(Parcel in) {
        this.nama_hotel = in.readString();
        this.lokasiHotel = in.readString();
        this.gambarHotel = in.readString();
        this.latitudeHotel = in.readString();
        this.longitudeHotel = in.readString();
        this.deskripsiHotel = in.readString();
    }

    public static final Creator<HotelModel> CREATOR = new Creator<HotelModel>() {
        @Override
        public HotelModel createFromParcel(Parcel source) {
            return new HotelModel(source);
        }

        @Override
        public HotelModel[] newArray(int size) {
            return new HotelModel[size];
        }
    };

    @Override
    public String toString() {
        return "HotelModel{" +
                "nama_hotel='" + nama_hotel + '\'' +
                ", lokasiHotel='" + lokasiHotel + '\'' +
                ", gambarHotel='" + gambarHotel + '\'' +
                ", latitudeHotel='" + latitudeHotel + '\'' +
                ", longitudeHotel='" + longitudeHotel + '\'' +
                ", deskripsiHotel='" + deskripsiHotel + '\'' +
                '}';
    }
}
