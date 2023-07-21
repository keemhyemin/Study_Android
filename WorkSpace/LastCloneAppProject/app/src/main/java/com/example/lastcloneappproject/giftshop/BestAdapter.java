package com.example.lastcloneappproject.giftshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemBestRecvBinding;
import com.example.lastcloneappproject.databinding.ItemNewRecvBinding;

import java.util.ArrayList;

public class BestAdapter extends RecyclerView.Adapter<BestAdapter.ViewHolder>{

    ItemBestRecvBinding binding;
    ArrayList<DrinkDTO> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemBestRecvBinding.inflate(inflater, parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgv.setImageResource(list.get(i).getImgRes());
        h.binding.tv.setText(list.get(i).getDrinkName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemBestRecvBinding binding;

        public ViewHolder(@NonNull ItemBestRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
