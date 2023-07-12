package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.databinding.FragmentGiftShopBinding;

public class GiftShopFragment extends Fragment {

    FragmentGiftShopBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGiftShopBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}