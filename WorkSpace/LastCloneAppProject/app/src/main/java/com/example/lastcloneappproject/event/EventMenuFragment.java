package com.example.lastcloneappproject.event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentEventMenuBinding;
import com.example.lastcloneappproject.giftshop.EGiftMenuFragment;
import com.example.lastcloneappproject.home.HomeFragment;

public class EventMenuFragment extends Fragment {

    FragmentEventMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEventMenuBinding.inflate(inflater, container, false);

        binding.lnEvent.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_eventcontainer, new EventFragment()).commit();
        });

        return binding.getRoot();
    }
}