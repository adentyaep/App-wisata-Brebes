package com.example.appwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterHotel extends RecyclerView.Adapter<AdapterHotel.HolderData> {
    List<HotelModel> listHotel;
    LayoutInflater inflater;
    Context context;
    Callback callback;

    public AdapterHotel(List<HotelModel> listHotel, LayoutInflater inflater, Context context, Callback callback) {
        this.listHotel = listHotel;
        this.inflater = inflater;
        this.context = context;
        this.callback = callback;
    }

    public void setFilteredHotel(List<HotelModel> filteredHotel){
        this.listHotel = filteredHotel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterHotel.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_hotel, parent, false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        HotelModel hotelModel = listHotel.get(position);
        holder.txtNamaHotel.setText(hotelModel.getNama_hotel());
        holder.txtLokasiHotel.setText(hotelModel.getLokasiHotel());
        holder.txtDeskripsi.setText(hotelModel.getDeskripsiHotel());
        Glide.with(context).load(hotelModel.getGambarHotel()).into(holder.gambarHotel);

        holder.linearLayout.setOnClickListener(v -> {
            callback.onClick(hotelModel);
        });
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtNamaHotel, txtLokasiHotel, txtDeskripsi;
        ImageView gambarHotel;
        LinearLayout linearLayout;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            gambarHotel = itemView.findViewById(R.id.idGambarHotel);
            txtNamaHotel = itemView.findViewById(R.id.txt_nama_hotel);
            txtLokasiHotel = itemView.findViewById(R.id.txt_lokasi_hotel);
            linearLayout = itemView.findViewById(R.id.idListHotel);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);
        }
    }
}
