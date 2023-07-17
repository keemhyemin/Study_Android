package com.example.lastcloneappproject.stamp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.coupon.Coupon1Fragment;
import com.example.lastcloneappproject.databinding.FragmentStampMenuBinding;
import com.example.lastcloneappproject.home.HomeFragment;

public class StampMenuFragment extends Fragment {

    FragmentStampMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStampMenuBinding.inflate(inflater, container, false);

        FragmentTransaction mainTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        mainTransaction.replace(R.id.ln_stampcontainer, new StampFragment()).commit();

        binding.imgvBefore.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        binding.imgvHome.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        binding.btnStamp.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_stampcontainer, new StampFragment()).commit();
        });

        binding.btnList.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_stampcontainer, new ListFragment()).commit();
        });

        return binding.getRoot();
    }
}