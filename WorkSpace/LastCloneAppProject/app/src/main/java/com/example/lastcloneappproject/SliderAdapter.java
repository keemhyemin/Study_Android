package com.example.lastcloneappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemBannerBinding;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    ItemBannerBinding binding;
    int[] banArr;

    public SliderAdapter(int[] banArr) {
        this.banArr = banArr;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemBannerBinding.inflate(inflater, parent, false);
        return new SliderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder h, int i) {
        h.binding.imgvBanner.setImageResource(banArr[i]);
    }

    @Override
    public int getItemCount() {
        return banArr.length;
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        ItemBannerBinding binding;

        public SliderViewHolder(@NonNull ItemBannerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
