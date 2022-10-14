package com.example.appwisata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Callback {
    RecyclerView recyclerViewWisata, recyclerViewHotel;
    //    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    AdapterHotel adapterHotel;
    List<WisataModel> listData;
    List<HotelModel> listHotel = new ArrayList<>();
    List<RestoranModel> listRestoran = new ArrayList<>();
    WisataModel wisataModel;
    HotelModel hotelModel;
    RestoranModel restoranModel;
    SessionManager sessionManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        searchView = findViewById(R.id.edtSearch);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterWisata(newText);

                return true;
            }
        });
        recyclerViewWisata = findViewById(R.id.rvWisata);
        recyclerViewHotel = findViewById(R.id.rvHotel);
        getDataWisata();
        getDataHotel();
        getDataRestoran();


    }

//    public boolean checkNetworkConnection() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//
//        return (networkInfo != null && networkInfo.isConnected());
//    }

    @Override
    public void onClick(WisataModel params) {

        Intent intent = new Intent(getApplicationContext(), detailWisata.class);

        intent.putExtra("nama_wisata", params.getNama_wisata());
        intent.putExtra("desa", params.getLokasiWisata());
        intent.putExtra("gambar", params.getGambarWisata());
        intent.putExtra("longitude", params.getLongitude());
        intent.putExtra("latitude", params.getLatitude());
        intent.putExtra("deskripsi", params.getDeskripsi());
        intent.putExtra("hotel", new Gson().toJson(listHotel));
        intent.putExtra("restoran", new Gson().toJson(listRestoran));

        startActivity(intent);
    }

    @Override
    public void onClick(HotelModel params) {

        Intent intent = new Intent(getApplicationContext(), detailHotel.class);

        intent.putExtra("nama_hotel", params.getNama_hotel());
        intent.putExtra("desa", params.getLokasiHotel());
        intent.putExtra("gambar", params.getGambarHotel());
        intent.putExtra("longitude", params.getLongitudeHotel());
        intent.putExtra("latitude", params.getLatitudeHotel());
        intent.putExtra("deskripsi", params.getDeskripsiHotel());
        intent.putExtra("wisata", new Gson().toJson(listData));
        intent.putExtra("restoran", new Gson().toJson(listRestoran));

        startActivity(intent);
    }

    private void getDataWisata() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, DbContract.SERVER_GET_WISATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    listData = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("server_response");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        wisataModel = new WisataModel();
                        JSONObject data = jsonArray.getJSONObject(i);
                        wisataModel.setNama_wisata(data.getString("nama_wisata"));
                        wisataModel.setGambarWisata(data.getString("gambar"));
                        wisataModel.setLokasiWisata(data.getString("desa"));
                        wisataModel.setLongitude(data.getString("longitude"));
                        wisataModel.setLatitude(data.getString("latitude"));
                        wisataModel.setDeskripsi(data.getString("deskripsi"));
                        listData.add(wisataModel);
                    }
                    adapterData = new AdapterData(listData, getLayoutInflater(), MainActivity.this, MainActivity.this);
                    recyclerViewWisata.setAdapter(adapterData);
                    adapterData.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Database Error", Toast.LENGTH_SHORT);
            }
        });
        requestQueue.add(stringRequest);

    }

    private void getDataHotel() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, DbContract.SERVER_GET_HOTEL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("server_response");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        hotelModel = new HotelModel();
                        JSONObject data = jsonArray.getJSONObject(i);
                        hotelModel.setNama_hotel(data.getString("nama_hotel"));
                        hotelModel.setGambarHotel(data.getString("gambar"));
                        hotelModel.setLokasiHotel(data.getString("desa"));
                        hotelModel.setLatitudeHotel(data.getString("latitude"));
                        hotelModel.setLongitudeHotel(data.getString("longitude"));
                        hotelModel.setDeskripsiHotel(data.getString("deskripsi"));
                        listHotel.add(hotelModel);

                    }
                    adapterHotel = new AdapterHotel(listHotel, getLayoutInflater(), MainActivity.this, MainActivity.this);
                    recyclerViewHotel.setAdapter(adapterHotel);
                    adapterHotel.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Database Error", Toast.LENGTH_SHORT);
            }
        });
        requestQueue.add(stringRequest);

    }

    private void getDataRestoran() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, DbContract.SERVER_GET_RESTORAN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("server_response");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        restoranModel = new RestoranModel();
                        JSONObject data = jsonArray.getJSONObject(i);
                        restoranModel.setNama_restoran(data.getString("nama_restoran"));
                        restoranModel.setGambarRestoran(data.getString("gambar"));
                        restoranModel.setLokasiRestoran(data.getString("desa"));
                        restoranModel.setLatitudeRestoran(data.getString("latitude"));
                        restoranModel.setLongitudeRestoran(data.getString("longitude"));
                        restoranModel.setDeskripsiResto(data.getString("deskripsi"));
                        listRestoran.add(restoranModel);

                    }
//                    adapterHotel = new AdapterHotel(listHotel, getLayoutInflater(), MainActivity.this);
//                    recyclerViewHotel.setAdapter(adapterHotel);
//                    adapterHotel.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Database Error", Toast.LENGTH_SHORT);
            }
        });
        requestQueue.add(stringRequest);

    }

    private void filterWisata(String text) {
        List<WisataModel> filteredWisata = new ArrayList<>();
        List<HotelModel> filteredHotel = new ArrayList<>();

        for (WisataModel wisata: listData){
            if (wisata.getNama_wisata().toLowerCase().contains(text.toLowerCase())){
                filteredWisata.add(wisata);
            }
        }

        for (HotelModel hotel: listHotel){
            if (hotel.getNama_hotel().toLowerCase().contains(text.toLowerCase())){
                filteredHotel.add(hotel);
            }
        }

        if (filteredWisata.isEmpty() && filteredHotel.isEmpty()){
            Toast.makeText(this,"Tidak Ada Data Yang Dicari", Toast.LENGTH_SHORT).show();
        }else{
            adapterData.setFilteredWisata(filteredWisata);
            adapterHotel.setFilteredHotel(filteredHotel);
        }
    }


}