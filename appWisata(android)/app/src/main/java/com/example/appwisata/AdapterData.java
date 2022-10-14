package com.example.appwisata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<WisataModel> listData;
    LayoutInflater inflater;
    Context context;
    Callback callback;

    public AdapterData(List<WisataModel> listData,  LayoutInflater inflater, Context context, Callback callback) {
        this.listData = listData;
        this.inflater = inflater;
        this.context = context;
        this.callback = callback;
    }

    //    public AdapterData(List<WisataModel> listData, LayoutInflater inflater, Context context) {
//        this.listData = listData;
//        this.inflater = inflater;
////        this.callback = callback;
//        this.context = context;
//    }

    public void setFilteredWisata(List<WisataModel> filteredWisata){
        this.listData = filteredWisata;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_wisata, parent, false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        WisataModel wisataModel = listData.get(position);
        holder.txtNamaWisata.setText(wisataModel.getNama_wisata());
        holder.txtLokasiWisata.setText(wisataModel.getLokasiWisata());
        holder.txtDeskripsi.setText(wisataModel.getDeskripsi());
        Glide.with(context).load(wisataModel.getGambarWisata()).into(holder.gambarWisata);

        holder.linearLayout.setOnClickListener(view -> {
            callback.onClick(wisataModel);
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtNamaWisata, txtLokasiWisata, txtDeskripsi;
        ImageView gambarWisata;
        LinearLayout linearLayout;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            gambarWisata = itemView.findViewById(R.id.idGambarWisata);
            txtNamaWisata = itemView.findViewById(R.id.txt_nama_wisata);
            txtLokasiWisata = itemView.findViewById(R.id.txt_lokasi_wisata);
            linearLayout = itemView.findViewById(R.id.idListWisata);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);

        }
    }
}
