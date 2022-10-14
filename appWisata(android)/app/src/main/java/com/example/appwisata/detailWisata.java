package com.example.appwisata;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.Asserts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class detailWisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        ImageView gmbWisata = findViewById(R.id.gmbWisata);
        TextView txt_nmWisata = findViewById(R.id.txt_nmWisata);
        TextView txt_locWisata = findViewById(R.id.txt_locWisata);
        TextView txt_deskripsi = findViewById(R.id.txt_deskripsi);
        TextView txt_HotelDekat = findViewById(R.id.txt_hotel);
        TextView txt_jarakHotelDekat = findViewById(R.id.txt_jarakHotel);
        TextView txt_RestoDekat = findViewById(R.id.txt_Restoran);
        TextView txt_jarakRestoranDekat = findViewById(R.id.txt_jarakRestoran);



        Intent intent = getIntent();
        String nmWisata = intent.getStringExtra("nama_wisata");
        String lokasi = intent.getStringExtra("desa");
        String gambar = intent.getStringExtra("gambar");
        String longi = intent.getStringExtra("longitude");
        String latit = intent.getStringExtra("latitude");
        String deskripsi = intent.getStringExtra("deskripsi");

        double latitudeWis = Double.valueOf(latit);
        double longitudeWis = Double.valueOf(longi);
//        double temp;

        TypeToken typeToken = new TypeToken<List<HotelModel>>(){};
        List<HotelModel> listHotel = new Gson().fromJson(intent.getStringExtra("hotel"), typeToken.getType());

        TypeToken typeToken1 = new TypeToken<List<RestoranModel>>(){};
        List<RestoranModel> listRestoran = new Gson().fromJson(intent.getStringExtra("restoran"), typeToken1.getType());

        List<Double> hasilHitungHotel = new ArrayList<>();
        List<Double> hasilHitungRestoran = new ArrayList<>();

        for(HotelModel hotel: listHotel) {

            Double lat1 = Double.valueOf(hotel.getLatitudeHotel());
            Double lon1 = Double.valueOf(hotel.getLongitudeHotel());
            Double lat2 = latitudeWis;
            Double lon2 = longitudeWis;
            Double R = 6317.0;

            Double latRad1 = lat1 * (Math.PI / 180.0);
            Double latRad2 = lat2 * (Math.PI / 180.0);
            Double deltaLatRad = (lat2 - lat1) * (Math.PI / 180.0);
            Double deltaLonRad = (lon2 - lon1) * (Math.PI / 180.0);

            Double a = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.sin(deltaLonRad / 2) * Math.sin(deltaLonRad);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            Double s = R * c;

            hasilHitungHotel.add(s);

        }

        for(RestoranModel restoran: listRestoran) {

            Double lat1 = Double.valueOf(restoran.getLatitudeRestoran());
            Double lon1 = Double.valueOf(restoran.getLongitudeRestoran());
            Double lat2 = latitudeWis;
            Double lon2 = longitudeWis;
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



        // hotel terdekat
        int minIndexHotel = hasilHitungHotel.indexOf(Collections.min(hasilHitungHotel));
        double jarakTerdekatHotel = Collections.min(hasilHitungHotel);
        DecimalFormat df = new DecimalFormat("#.##");
        txt_HotelDekat.setText(listHotel.get(minIndexHotel).getNama_hotel());
        txt_jarakHotelDekat.setText(df.format(jarakTerdekatHotel) + " km");

        // restoran terdekat
        int minIndexResto = hasilHitungRestoran.indexOf(Collections.min(hasilHitungRestoran));
        double jarakTerdekatResto = Collections.min(hasilHitungRestoran);
        txt_RestoDekat.setText(listRestoran.get(minIndexResto).getNama_restoran());
        txt_jarakRestoranDekat.setText(df.format(jarakTerdekatResto) + " km");




//        Node nodeWisata = new Node(nmWisata);
//        Graph graph = new Graph();
//        graph.addNode(nodeWisata);
//
//        for (int a = 0; a < listHotel.size(); a++){
//            Node nodeHotel = new Node("Hotel ke" + a);
//            nodeWisata.addDestination(nodeHotel, hasilHitung.get(a));
//            graph.addNode(nodeHotel);
//        }
//
//        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeWisata);



//        Bundle bundle = i.getExtras();
//        Parcelable[] parcelables=  bundle.getParcelableArray("hotel");
//        List<HotelModel> listHotel = new ArrayList();
//
//        if(parcelables != null) {
//            Log.e("debug", "onCreate: " + parcelables[0].toString());
//        }

//        for(Parcelable item: parcelables) {
//            listHotel.add((HotelModel) item);
//
        Glide.with(this).load(gambar).into(gmbWisata);
        txt_nmWisata.setText(nmWisata);
        txt_deskripsi.setText(deskripsi);
        txt_locWisata.setText(lokasi);

        Button btnRute = findViewById(R.id.btnRute);

        btnRute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailWisata.this, MapsActivity.class);
                intent.putExtra("logitude", longi);
                intent.putExtra("latitude", latit);
                intent.putExtra("nama_wisata", nmWisata);
                intent.putExtra("latitude_hotel", listHotel.get(minIndexHotel).getLatitudeHotel());
                intent.putExtra("longitude_hotel", listHotel.get(minIndexHotel).getLongitudeHotel());
                intent.putExtra("nama_hotel", listHotel.get(minIndexHotel).getNama_hotel());
                intent.putExtra("latitude_restoran", listRestoran.get(minIndexResto).getLatitudeRestoran());
                intent.putExtra("longitude_restoran", listRestoran.get(minIndexResto).getLongitudeRestoran());
                intent.putExtra("nama_restoran", listRestoran.get(minIndexResto).getNama_restoran());
                startActivity(intent);
            }
        });

    }



//    private Double getDistance(Double latitudeHotel, Double longitudeHotel, Double latitudeWisata, Double longitudeWisata) {
//            Double lat1 = latitudeHotel;
//            Double lon1 = longitudeHotel;
//            Double lat2 = latitudeWisata;
//            Double lon2 = longitudeWisata;
//            Double R = 6317.0;
//
//            Double latRad1 = lat1 * (Math.PI / 180.0);
//            Double latRad2 = lat2 * (Math.PI / 180.0);
//            Double deltaLatRad = (lat2 - lat1) * (Math.PI / 180.0);
//            Double deltaLonRad = (lon2 - lon1) * (Math.PI / 180.0);
//
//            Double a = Math.sin(deltaLatRad / 2) * Math.sin(deltaLatRad / 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.sin(deltaLonRad / 2) * Math.sin(deltaLonRad);
//            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//            Double s = R * c;
//
//        return s;
//    }

}