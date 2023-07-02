package com.example.lastcloneappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lastcloneappproject.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_container, new HomeFragment()).commit();

        setContentView(binding.getRoot());
    }


}