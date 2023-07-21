package com.example.lastcloneappproject.giftshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentEGiftMenuBinding;

public class EGiftMenuFragment extends Fragment {

    FragmentEGiftMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEGiftMenuBinding.inflate(inflater, container, false);

        FragmentTransaction subTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        subTransaction.replace(R.id.ln_subcontainer, new NewFragment()).commit();

        binding.btn1.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_subcontainer, new NewFragment()).commit();
        });

        binding.btn2.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_subcontainer, new BestCombFragment()).commit();
        });

        return binding.getRoot();
    }
}