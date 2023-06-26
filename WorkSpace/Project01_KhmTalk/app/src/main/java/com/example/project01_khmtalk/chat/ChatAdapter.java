package com.example.project01_khmtalk.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_khmtalk.databinding.ItemChatRecvBinding;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    ItemChatRecvBinding binding;
    ArrayList<ChatDTO> list;


    public ChatAdapter(ArrayList<ChatDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemChatRecvBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getImgRes());
        h.binding.tvChatname.setText(list.get(i).getChatName());
        h.binding.tvChatmsg.setText(list.get(i).getChatMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemChatRecvBinding binding;

        public ViewHolder(@NonNull ItemChatRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
