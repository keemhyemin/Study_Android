package com.example.lastcloneappproject.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.NoticeFragment;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentHomeBinding;
import com.example.lastcloneappproject.databinding.FragmentOrderBinding;
import com.example.lastcloneappproject.home.HomeFragment;
import com.example.lastcloneappproject.home.SliderAdapter;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    FragmentOrderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        binding.recvOrder.setAdapter(new OrderAdapter(getList()));
        binding.recvOrder.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.imgvBefore.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        binding.imgvHome.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.ln_container, new HomeFragment()).commit();
        });

        return binding.getRoot();
    }

    public ArrayList<OrderDTO> getList() {
        ArrayList<OrderDTO> list = new ArrayList<>();
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"태평로점", "서울특별시 중구 세종대로14길6-2", "126m"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"대한상공회의소점", "서울특별시 중구 세종대로 39\n대한상공회의소 B1", "287m"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"숭례문점", "서울특별시 중구 세종대로 22, 1층\n(남대문로 5가)", "495m"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"명동역점", "서울특별시 중구 충무로1가 24-31", "747m"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"정동점", "서울특별시 중구 새문안로 26\n청양빌딩 1층", "798m"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"서울역점", "서울특별시 중구 한강대로 405,\n경부 고속철도 서울민자역사 b1", "1.1km"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"공차본사교육장", "서울특별시 종로구 종로 지하 55", "1.1km"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"을지로2가점", "서울특별시 중구 삼일대로 358\n(을지로2가 88-5)", "1.2km"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"아현역점", "서울특별시 서대문구 신촌로 35길 10", "1.8km"));
        list.add(new OrderDTO(R.drawable.fav, R.drawable.dot,"을지로트윈타워점", "서울특별시 중구 을지로 170,\n1층 111호(을지로4가)", "1.9km"));
        return list;
    }
}