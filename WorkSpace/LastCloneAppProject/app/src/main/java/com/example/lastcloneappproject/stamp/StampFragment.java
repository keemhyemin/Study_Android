package com.example.lastcloneappproject.stamp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentStampBinding;

public class StampFragment extends Fragment {

    FragmentStampBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStampBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}