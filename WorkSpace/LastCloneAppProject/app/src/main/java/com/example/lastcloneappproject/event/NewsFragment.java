package com.example.lastcloneappproject.event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentNewsBinding;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    FragmentNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        binding.recvNews.setAdapter(new NewsAdapter(getList()));
        binding.recvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public ArrayList<NewsDTO> getList() {
        ArrayList<NewsDTO> list = new ArrayList<>();
        list.add(new NewsDTO("2023.07.19", "공차코리아, 스파클링 티 신규 카테고\n리 신메뉴 8종 출시!", "자세히 보기"));
        list.add(new NewsDTO("2023.06.27", "공차코리아, 약과 2종 신메뉴 출시! 초\n당 옥수수 2종 재출시!", "자세히 보기"));
        list.add(new NewsDTO("2023.05.01", "공차코리아, 블랙사파이어 포도 신메뉴\n 3종 출시!", "자세히 보기"));
        list.add(new NewsDTO("2023.03.23", "공차코리아, 우롱티 스페셜 3종 출시", "자세히 보기"));
        list.add(new NewsDTO("2023.02.02", "Refresh Everyday 우롱티!", "자세히 보기"));
        list.add(new NewsDTO("2023.02.01", "공차코리아, '딸기 홀릭 3종' 출시", "자세히 보기"));
        list.add(new NewsDTO("2023.01.24", "토끼해 한정 메뉴 출시", "자세히 보기"));
        list.add(new NewsDTO("2023.12.07", "공차코리아, '베이커리 4종' 출시", "자세히 보기"));
        list.add(new NewsDTO("2022.11.30", "22년 12월 2일 세종, 제주 공차 매장 컵\n 보증금 시행 안내", "자세히 보기"));
        list.add(new NewsDTO("2022.10.17", "공차코리아, '할로윈' 시즌 한정 스페셜 음료 출시", "자세히 보기"));
        return list;
    }
}