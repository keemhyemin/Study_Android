package com.example.lastcloneappproject.stamp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.coupon.CouponMenuFragment;
import com.example.lastcloneappproject.databinding.FragmentStampBinding;
import com.example.lastcloneappproject.order.OrderFragment;

public class StampFragment extends Fragment {

    FragmentStampBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStampBinding.inflate(inflater, container, false);
        binding.imgvStmbtn2.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new CouponMenuFragment()).commit();
        });
        return binding.getRoot();
    }
}