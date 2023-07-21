package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentNewBinding;
import com.example.lastcloneappproject.event.NewsAdapter;

import java.util.ArrayList;

public class NewFragment extends Fragment {

    FragmentNewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewBinding.inflate(inflater, container, false);
        binding.recvNew.setAdapter(new NewAdapter(getList()));
        binding.recvNew.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return binding.getRoot();
    }
    public ArrayList<DrinkDTO> getList() {
        ArrayList<DrinkDTO> list = new ArrayList<>();
        list.add(new DrinkDTO(R.drawable.new1, "얼그레이 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new2, "우롱 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new3, "자스민그린 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new4, "블랙 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new5, "트로피칼 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new6, "청귤 스파클링 티"));
        list.add(new DrinkDTO(R.drawable.new7, "오리지널 콤부차 + 알로에"));
        list.add(new DrinkDTO(R.drawable.new8, "패션 프룻 히비스커스"));
        return list;
    }
}