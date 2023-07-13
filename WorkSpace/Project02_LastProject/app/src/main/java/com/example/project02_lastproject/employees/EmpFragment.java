package com.example.project02_lastproject.employees;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.FragmentEmpBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EmpFragment extends Fragment {

    FragmentEmpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmpBinding.inflate(inflater, container, false);
        select();
        return binding.getRoot();
    }

    public void select() {
        CommonConn conn = new CommonConn(getContext(), "list.emp");
        conn.onExcute((isResult, data) -> {
            ArrayList<EmployeesVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<EmployeesVO>>(){}.getType());
            EmpAdapter adapter = new EmpAdapter(list);
            binding.recvEmp.setAdapter(adapter);
            binding.recvEmp.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }
}