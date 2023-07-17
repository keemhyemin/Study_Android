package com.example.lastcloneappproject.coupon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentCoupon2Binding;

public class Coupon2Fragment extends Fragment {

    FragmentCoupon2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoupon2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}