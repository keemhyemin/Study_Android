package com.example.lastcloneappproject.event;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemNewsRecvBinding;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    ItemNewsRecvBinding binding;
    ArrayList<NewsDTO> list;

    public NewsAdapter(ArrayList<NewsDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemNewsRecvBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvDate.setText(list.get(i).getDate());
        h.binding.tvTitle.setText(list.get(i).getTitle());
        h.binding.tvMore.setText(list.get(i).getMore());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsRecvBinding binding;

        public ViewHolder(@NonNull ItemNewsRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
