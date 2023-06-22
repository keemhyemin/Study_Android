package com.example.and09_fragmentadapter.practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class AdapterMelv extends RecyclerView.Adapter<AdapterMelv.MelViewHolder> {

    LayoutInflater inflater;
    ArrayList<MelvDTO> list;

    public AdapterMelv(LayoutInflater inflater, ArrayList<MelvDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public MelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_practice, parent, false);
        return new MelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MelViewHolder holder, int i) {
        holder.imgv_img.setImageResource(list.get(i).getImgRes());
        holder.tv_num.setText(list.get(i).getNum() + "");
        holder.tv_song.setText(list.get(i).getSong());
        holder.tv_singer.setText(list.get(i).getSinger());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MelViewHolder extends RecyclerView.ViewHolder {

        ImageView imgv_img;
        TextView tv_num, tv_song, tv_singer;
        public MelViewHolder(@NonNull View v) {
            super(v);
            imgv_img = v.findViewById(R.id.imgv_img);
            tv_num = v.findViewById(R.id.tv_num);
            tv_song = v.findViewById(R.id.tv_song);
            tv_singer = v.findViewById(R.id.tv_singer);
        }
    }
}
