package com.example.lastcloneappproject.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemOrderRecvBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ItemOrderRecvBinding binding;
    ArrayList<OrderDTO> list;

    public OrderAdapter(ArrayList<OrderDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOrderRecvBinding.inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvFav2.setVisibility(View.INVISIBLE);
        h.binding.imgvFav.setImageResource(list.get(i).getImgfav());
        h.binding.tvShop.setText(list.get(i).getShop());
        h.binding.tvAddress.setText(list.get(i).getAddress());
        h.binding.imgvDot.setImageResource(list.get(i).getImgdot());
        h.binding.tvDistance.setText(list.get(i).getDistance());
        h.binding.imgvFav.setOnClickListener(view -> {
            h.binding.imgvFav2.setVisibility(View.VISIBLE);
            h.binding.imgvFav.setVisibility(View.INVISIBLE);
        });
        h.binding.imgvFav2.setOnClickListener(v -> {
            h.binding.imgvFav2.setVisibility(View.INVISIBLE);
            h.binding.imgvFav.setVisibility(View.VISIBLE);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderRecvBinding binding;

        public ViewHolder(@NonNull ItemOrderRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
