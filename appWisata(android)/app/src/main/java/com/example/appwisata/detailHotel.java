package com.example.appwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class detailHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        ImageView gmbHotel = findViewById(R.id.gmbHotel);
        TextView txt_nmHotel = findViewById(R.id.txt_nmHotel);
        TextView txt_locHotel = findViewById(R.id.txt_locHotel);
        TextView txt_deskripsi = findViewById(R.id.txt_deskripsiHotel);
        TextView txt_wisata = findViewById(R.id.namaWisata);
        TextView txt_jarakWisataDekat = findViewById(R.id.jarakWisata);
        TextView txt_RestoDekat = findViewById(R.id.txt_Restoran);
        TextView txt_jarakRestoranDekat = findViewById(R.id.txt_jarakRestoran);



        Intent intent = getIntent();
        String nmHotel = intent.getStringExtra("nama_hotel");
        String lokasi = intent.getStringExtra("desa");
        String gambar = intent.getStringExtra("gambar");
        String longi = intent.getStringExtra("longitude");
        String latit = intent.getStringExtra("latitude");
        String deskripsi = intent.getStringExtra("deskripsi");

        double latitudeHotel = Double.valueOf(latit);
        double longitudeHotel = Double.valueOf(longi);

        TypeToken typeToken = new TypeToken<List<WisataModel>>(){};
        List<WisataModel> listWisata = new Gson().fromJson(intent.getStringExtra("wisata"), typeToken.getType());

        TypeToken typeToken1 = new TypeToken<List<RestoranModel>>(){};
        List<RestoranModel> listRestoran = new Gson().fromJson(intent.getStringExtra("restoran"), typeToken1.getType());

        List<Double> hasilHitungWisata = new ArrayList<>();
        List<Double> hasilHitungRestoran = new ArrayList<>();

        for(WisataModel wisata: listWisata) {

            Double lat1 = Double.valueOf(wisata.getLatitude());
            Double lon1 = Double.valueOf(wisata.getLongitude());
            Double lat2 = latitudeHotel;
            Double lon2 = longitudeHotel;
            Double R = 6317.0;

            Double latRad1 = lat1 * (Math.PI / 180.0);
            Double latRad2 = lat2 * (Math.PI / 180.0);
            Double deltaLatRad = (lat2 - lat1) * (Math.PI / 180.0);
            Double deltaLonRad = (lon2 - lon1) * (Math.PI / 180.0);

            Double a = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.sin(deltaLonRad / 2) * Math.sin(deltaLonRad);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double s = R * c;

            hasilHitungWisata.add(s);

        }

        for(RestoranModel restoran: listRestoran) {

            Double lat1 = Double.valueOf(restoran.getLatitudeRestoran());
            Double lon1 = Double.valueOf(restoran.getLongitudeRestoran());
            Double lat2 = latitudeHotel;
            Double lon2 = longitudeHotel;
            Double R = 6317.0;

            Double latRad1 = lat1 * (Math.PI / 180.0);
            Double latRad2 = lat2 * (Math.PI / 180.0);
            Double deltaLatRad = (lat2 - lat1) * (Math.PI / 180.0);
            Double deltaLonRad = (lon2 - lon1) * (Math.PI / 180.0);

            Double a = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.sin(deltaLonRad / 2) * Math.sin(deltaLonRad);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double s = R * c;

            hasilHitungRestoran.add(s);

        }



        // wisata terdekat
        int minIndexWisata = hasilHitungWisata.indexOf(Collections.min(hasilHitungWisata));
        double jarakTerdekatWisata = Collections.min(hasilHitungWisata);
        DecimalFormat df = new DecimalFormat("#.##");
        txt_wisata.setText(listWisata.get(minIndexWisata).getNama_wisata());
        txt_jarakWisataDekat.setText(df.format(jarakTerdekatWisata) + " km");

        // restoran terdekat
        int minIndexResto = hasilHitungRestoran.indexOf(Collections.min(hasilHitungRestoran));
        double jarakTerdekatResto = Collections.min(hasilHitungRestoran);
        txt_RestoDekat.setText(listRestoran.get(minIndexResto).getNama_restoran());
        txt_jarakRestoranDekat.setText(df.format(jarakTerdekatResto) + " km");

        Glide.with(this).load(gambar).into(gmbHotel);
        txt_nmHotel.setText(nmHotel);
        txt_deskripsi.setText(deskripsi);
        txt_locHotel.setText(lokasi);

        Button btnRute = findViewById(R.id.btnRute);

        btnRute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailHotel.this, MapsActivity.class);
                intent.putExtra("logitude", longi);
                intent.putExtra("latitude", latit);
                intent.putExtra("nama_wisata", nmHotel);
                intent.putExtra("latitude_hotel", listWisata.get(minIndexWisata).getLatitude());
                intent.putExtra("longitude_hotel", listWisata.get(minIndexWisata).getLongitude());
                intent.putExtra("nama_hotel", listWisata.get(minIndexWisata).getNama_wisata());
                intent.putExtra("latitude_restoran", listRestoran.get(minIndexResto).getLatitudeRestoran());
                intent.putExtra("longitude_restoran", listRestoran.get(minIndexResto).getLongitudeRestoran());
                intent.putExtra("nama_restoran", listRestoran.get(minIndexResto).getNama_restoran());
                startActivity(intent);
            }
        });
    }
}