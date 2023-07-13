package com.example.project02_lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.customer.CustomerFragment;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.example.project02_lastproject.databinding.ActivityMainBinding;
import com.example.project02_lastproject.employees.EmpFragment;

import java.util.HashMap;

import kotlin.jvm.internal.markers.KMappedMarker;
import me.ibrahimsn.lib.OnItemSelectedListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CustomerFragment()).commit();

        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                if(i==0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new CustomerFragment()).commit();
                }else if(i==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new EmpFragment()).commit();
                }else if(i==2){

                }else if(i==3){

                }
                return false;
            }
        });


    }
}