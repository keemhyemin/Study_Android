package com.example.lastcloneappproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.databinding.FragmentMainBinding;
import com.example.lastcloneappproject.databinding.MainBarBinding;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        binding.vpslider.setAdapter(new SliderAdapter(banArr));

        binding.imgvNotice.setOnClickListener(v -> {
            
        });

        return binding.getRoot();
    }
    int[] banArr = {R.drawable.img_banner1, R.drawable.img_banner2, R.drawable.img_banner3};
}