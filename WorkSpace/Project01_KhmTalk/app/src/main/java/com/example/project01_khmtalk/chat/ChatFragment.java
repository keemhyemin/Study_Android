package com.example.project01_khmtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_khmtalk.R;
import com.example.project01_khmtalk.databinding.FragmentChatBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        binding.recvChat.setAdapter(new ChatAdapter(getList()));
        binding.recvChat.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public ArrayList<ChatDTO> getList() {
        ArrayList<ChatDTO> list = new ArrayList<>();
        list.add(new ChatDTO(R.drawable.img1, "이름1", "안녕하세요1"));
        list.add(new ChatDTO(R.drawable.img2, "이름2", "안녕하세요2"));
        list.add(new ChatDTO(R.drawable.img3, "이름3", "안녕하세요3"));
        list.add(new ChatDTO(R.drawable.img4, "이름4", "안녕하세요4"));
        list.add(new ChatDTO(R.drawable.img5, "이름5", "안녕하세요5"));
        list.add(new ChatDTO(R.drawable.img6, "이름6", "안녕하세요6"));
        list.add(new ChatDTO(R.drawable.img7, "이름7", "안녕하세요7"));
        list.add(new ChatDTO(R.drawable.img8, "이름8", "안녕하세요8"));
        return list;
    }
}