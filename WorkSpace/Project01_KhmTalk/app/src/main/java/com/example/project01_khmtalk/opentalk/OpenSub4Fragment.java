package com.example.project01_khmtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_khmtalk.databinding.FragmentOpenSub1Binding;

public class OpenSub4Fragment extends Fragment {

    FragmentOpenSub1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenSub1Binding.inflate(inflater, container, false);
        binding.recv1Opensub.setAdapter(new OpenSub1Adapter1());
        binding.recv2Opensub.setAdapter(new OpenSub1Adapter2());

        binding.recv1Opensub.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recv2Opensub.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return binding.getRoot();
    }
}