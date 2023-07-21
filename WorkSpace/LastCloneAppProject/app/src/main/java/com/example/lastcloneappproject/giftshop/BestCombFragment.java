package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentBestCombBinding;

import java.util.ArrayList;

public class BestCombFragment extends Fragment {

    FragmentBestCombBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBestCombBinding.inflate(inflater, container, false);
        binding.recvBest.setAdapter(new NewAdapter(getList()));
        binding.recvBest.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return binding.getRoot();
    }
    public ArrayList<DrinkDTO> getList() {
        ArrayList<DrinkDTO> list = new ArrayList<>();
        list.add(new DrinkDTO(R.drawable.drink13, "하동 호지 밀크티 + 펄 L"));
        list.add(new DrinkDTO(R.drawable.drink13, "하동 호지 밀크티 + 펄 J"));
        list.add(new DrinkDTO(R.drawable.drink8, "우롱티+코코넛+밀크폼 L"));
        list.add(new DrinkDTO(R.drawable.drink8, "우롱티+코코넛+밀크폼 J"));
        list.add(new DrinkDTO(R.drawable.drink15, "자몽 그린티 + 알로에 L"));
        list.add(new DrinkDTO(R.drawable.drink15, "자몽 그린티 + 알로에 J"));
        list.add(new DrinkDTO(R.drawable.drink10, "블랙 밀크티 + 펄 L"));
        list.add(new DrinkDTO(R.drawable.drink10, "블랙 밀크티 + 펄 J"));
        list.add(new DrinkDTO(R.drawable.drink11, "타로 밀크티 + 펄 L"));
        list.add(new DrinkDTO(R.drawable.drink11, "타로 밀크티 + 펄 J"));
        list.add(new DrinkDTO(R.drawable.drink12, "망고 요구르트 + 화이트펄 L"));
        list.add(new DrinkDTO(R.drawable.drink12, "망고 요구르트 + 화이트펄 J"));
        return list;
    }
}