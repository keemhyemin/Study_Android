package com.example.and09_fragmentadapter.practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MelonFragment extends Fragment {

    RecyclerView melv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);
        melv = v.findViewById(R.id.melv);
        ArrayList<MelvDTO> list = getList();
        melv.setAdapter(new AdapterMelv(inflater, list));
        melv.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    ArrayList<MelvDTO> getList() {
        ArrayList<MelvDTO> list = new ArrayList<>();
        list.add(new MelvDTO(R.drawable.chart_img1, 1, "퀸카", "아이들"));
        list.add(new MelvDTO(R.drawable.chart_img2, 2, "I AM", "아이브"));
        list.add(new MelvDTO(R.drawable.chart_img3, 3, "Spicy", "에스파"));
        list.add(new MelvDTO(R.drawable.chart_img4, 4, "이브 어쩌고", "르세라핌"));
        list.add(new MelvDTO(R.drawable.chart_img5, 5, "사랑은 늘 도망가", "임영웅"));
        list.add(new MelvDTO(R.drawable.chart_img6, 6, "모래 알갱이", "임영웅"));
        list.add(new MelvDTO(R.drawable.chart_img7, 7, "우리들의 블루스", "임영웅"));
        return list;
    }

}