package com.example.lastcloneappproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lastcloneappproject.databinding.ActivityMainBinding;
import com.example.lastcloneappproject.databinding.ItemBannerBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding.sliderbanner.setAdapter(new SliderAdapter(banArr));
    }

   int[] banArr = {R.drawable.img_banner1, R.drawable.img_banner2, R.drawable.img_banner3};
}