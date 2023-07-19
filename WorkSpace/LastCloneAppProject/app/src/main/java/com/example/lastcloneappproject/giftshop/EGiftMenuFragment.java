package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.databinding.FragmentEGiftMenuBinding;

public class EGiftMenuFragment extends Fragment {

    FragmentEGiftMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEGiftMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}