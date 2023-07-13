package com.example.project02_lastproject.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.databinding.ItemRecvEmployeesBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {

    ArrayList<EmployeesVO> list;

    public EmpAdapter(ArrayList<EmployeesVO> list) {
        this.list = list;
    }
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemRecvEmployeesBinding binding = ItemRecvEmployeesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvName.setText(list.get(i).getEmp_name()+"");
        h.binding.tvId.setText("(" + list.get(i).getEmployee_id() + ")");
        h.binding.tvDept.setText(list.get(i).getDepartment_name()+"");
        h.binding.tvEmail.setText(list.get(i).getEmail() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvEmployeesBinding binding;

        public ViewHolder(@NonNull ItemRecvEmployeesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
