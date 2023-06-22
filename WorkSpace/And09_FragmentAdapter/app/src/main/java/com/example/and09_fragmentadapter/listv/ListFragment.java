package com.example.and09_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.img1, "캐릭터1", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img2, "캐릭터2", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img3, "캐릭터3", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img4, "캐릭터4", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img5, "캐릭터5", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img1, "캐릭터6", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img2, "캐릭터7", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img3, "캐릭터8", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img4, "캐릭터9", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img5, "캐릭터10", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img1, "캐릭터11", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img2, "캐릭터12", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img3, "캐릭터13", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img4, "캐릭터14", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img5, "캐릭터15", "ㅎㅇ"));

        listv = v.findViewById(R.id.listv);
        AdapterListView adapter = new AdapterListView(inflater, list);
        listv.setAdapter(adapter);

        return v;
    }
}