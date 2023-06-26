package com.example.project01_khmtalk.friend;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_khmtalk.MainActivity;
import com.example.project01_khmtalk.R;
import com.example.project01_khmtalk.databinding.FragmentFriendBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FriendFragment extends Fragment {
    FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater, container, false);

        binding.recvFriend.setAdapter(new FriendAdapter(getList(), getContext() ));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));

//        Intent intent = new Intent( getContext(), MainActivity.class);
//        startActivity(intent);
        return binding.getRoot();
    }

    public ArrayList<FriendDTO> getList() {
        ArrayList<FriendDTO> list = new ArrayList<>();
        list.add(new FriendDTO(R.drawable.img1, "이름1", "메세지1"));
        list.add(new FriendDTO(R.drawable.img2, "이름2", "메세지2"));
        list.add(new FriendDTO(R.drawable.img3, "이름3", "메세지3"));
        list.add(new FriendDTO(R.drawable.img4, "이름4", "메세지4"));
        list.add(new FriendDTO(R.drawable.img5, "이름5", "메세지5"));
        list.add(new FriendDTO(R.drawable.img6, "이름6", "메세지6"));
        list.add(new FriendDTO(R.drawable.img7, "이름7", "메세지7"));
        list.add(new FriendDTO(R.drawable.img8, "이름8", "메세지8"));
        return list;
    }
}