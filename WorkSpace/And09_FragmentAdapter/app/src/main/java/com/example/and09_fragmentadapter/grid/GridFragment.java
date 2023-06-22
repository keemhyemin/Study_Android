package com.example.and09_fragmentadapter.grid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.listv.ListDTO;

import java.util.ArrayList;

public class GridFragment extends Fragment {
    GridView gridv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        gridv = v.findViewById(R.id.gridv);
        AdapterGridView adapter = new AdapterGridView(inflater);
        gridv.setAdapter(adapter);

        return v;
    }
}