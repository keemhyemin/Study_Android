package com.example.project01_khmtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_khmtalk.databinding.ItemOpensubRecv2Binding;

public class OpenSub4Adapter2 extends RecyclerView.Adapter<OpenSub4Adapter2.ViewHolder> {

    ItemOpensubRecv2Binding binding;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOpensubRecv2Binding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.lnWorkholic.getContext();
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOpensubRecv2Binding binding;

        public ViewHolder(@NonNull ItemOpensubRecv2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
