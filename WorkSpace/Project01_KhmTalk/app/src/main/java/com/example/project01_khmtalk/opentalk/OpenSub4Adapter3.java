package com.example.project01_khmtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_khmtalk.databinding.ItemOpensubRecv3Binding;

public class OpenSub4Adapter3 extends RecyclerView.Adapter<OpenSub4Adapter3.ViewHolder> {

    ItemOpensubRecv3Binding binding;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOpensubRecv3Binding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.lnRecipe.getContext();
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOpensubRecv3Binding binding;

        public ViewHolder(@NonNull ItemOpensubRecv3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
