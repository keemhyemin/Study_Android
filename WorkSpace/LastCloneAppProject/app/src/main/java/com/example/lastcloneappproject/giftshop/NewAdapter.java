package com.example.lastcloneappproject.giftshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemNewRecvBinding;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {

    ItemNewRecvBinding binding;
    ArrayList<DrinkDTO> list;

    public NewAdapter(ArrayList<DrinkDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemNewRecvBinding.inflate(inflater, parent,false);
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
        ItemNewRecvBinding binding;

        public ViewHolder(@NonNull ItemNewRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
