package com.example.project01_khmtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_khmtalk.databinding.ItemOpensubRecv4Binding;

public class OpenSub1Adapter4 extends  RecyclerView.Adapter <OpenSub1Adapter4.ViewHolder> {

    ItemOpensubRecv4Binding binding;

    int[] geojiImgArr2;
    String[] geojiChatArr2;
    String[] geojiCntArr2;

    public OpenSub1Adapter4(int[] geojiImgArr2, String[] geojiChatArr2, String[] geojiCntArr2) {
        this.geojiImgArr2 = geojiImgArr2;
        this.geojiChatArr2 = geojiChatArr2;
        this.geojiCntArr2 = geojiCntArr2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOpensubRecv4Binding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvGeoji.setImageResource(geojiImgArr2[i]);
        h.binding.tvGeojichat.setText(geojiChatArr2[i]);
        h.binding.tvGeojicnt.setText(geojiCntArr2[i]);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOpensubRecv4Binding binding;

        public ViewHolder(@NonNull ItemOpensubRecv4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
