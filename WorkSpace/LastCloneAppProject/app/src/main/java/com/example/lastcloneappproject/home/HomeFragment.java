package com.example.lastcloneappproject.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.NoticeFragment;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.coupon.CouponMenuFragment;
import com.example.lastcloneappproject.databinding.FragmentHomeBinding;
import com.example.lastcloneappproject.giftshop.GiftShopFragment;
import com.example.lastcloneappproject.order.OrderFragment;
import com.example.lastcloneappproject.stamp.StampMenuFragment;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.vpslider.setAdapter(new SliderAdapter(banArr));

        binding.imgvNotice.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new NoticeFragment()).commit();
        });

        binding.imgvMenu1.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new OrderFragment()).commit();
        });

        binding.imgvMenu2.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new StampMenuFragment()).commit();
        });

        binding.imgvMenu3.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new CouponMenuFragment()).commit();
        });

        binding.lnGiftshop.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new GiftShopFragment()).commit();
        });

        binding.lnMap.setOnClickListener(v -> {

        });

        binding.lnEvent.setOnClickListener(v -> {

        });



        return binding.getRoot();
    }

    int[] banArr = {R.drawable.img_banner1, R.drawable.img_banner2, R.drawable.img_banner3};
}