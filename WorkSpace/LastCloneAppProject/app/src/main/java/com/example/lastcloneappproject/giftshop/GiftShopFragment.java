package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentGiftShopBinding;
import com.example.lastcloneappproject.home.HomeFragment;

public class GiftShopFragment extends Fragment {

    FragmentGiftShopBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGiftShopBinding.inflate(inflater, container, false);

        FragmentTransaction subTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        subTransaction.replace(R.id.ln_giftshopcontainer, new GiftShopSubFragment()).commit();

        binding.imgvBefore.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        binding.imgvHome.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        binding.imgvEgift.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_giftshopcontainer, new EGiftMenuFragment()).commit();
        });



        return binding.getRoot();
    }
}