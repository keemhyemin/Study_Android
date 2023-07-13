package com.example.lastcloneappproject.giftshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemDrinkRecvBinding;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {

    ItemDrinkRecvBinding binding;
    ArrayList<DrinkDTO> list;

    public DrinkAdapter(ArrayList<DrinkDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDrinkRecvBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvDrink.setImageResource(list.get(i).getImgRes());
        h.binding.tvDrink.setText(list.get(i).getDrinkName()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDrinkRecvBinding binding;

        public ViewHolder(@NonNull ItemDrinkRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
