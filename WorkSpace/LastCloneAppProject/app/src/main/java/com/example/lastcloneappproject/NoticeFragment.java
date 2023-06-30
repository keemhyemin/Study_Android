package com.example.lastcloneappproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.databinding.FragmentNoticeBinding;

public class NoticeFragment extends Fragment {

    FragmentNoticeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoticeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}