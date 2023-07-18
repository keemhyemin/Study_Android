package com.example.lastcloneappproject.stamp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentListBinding;
import com.example.lastcloneappproject.home.HomeFragment;

public class ListFragment extends Fragment {

    FragmentListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        FragmentTransaction maintransaction = getActivity().getSupportFragmentManager().beginTransaction();
        maintransaction.replace(R.id.ln_listcontainer, new AllFragment()).commit();

        binding.btnAll.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_listcontainer, new AllFragment()).commit();
        });

        binding.btnProceed.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_listcontainer, new ProceedFragment()).commit();
        });

        binding.btnComplete.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_listcontainer, new CompleteFragment()).commit();
        });

        return binding.getRoot();
    }
}