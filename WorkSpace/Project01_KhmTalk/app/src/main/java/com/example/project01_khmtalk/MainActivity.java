package com.example.project01_khmtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project01_khmtalk.chat.ChatFragment;
import com.example.project01_khmtalk.databinding.ActivityMainBinding;
import com.example.project01_khmtalk.friend.FriendFragment;
import com.example.project01_khmtalk.opentalk.OpenTalkMainFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구");

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FriendFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.tab1) {
                fragment = new FriendFragment();
                actionBar.setTitle("친구");
            } else if (item.getItemId() == R.id.tab2) {
                fragment = new ChatFragment();
                actionBar.setTitle("채팅");
            } else if (item.getItemId() == R.id.tab3) {
                fragment = new OpenTalkMainFragment();
                actionBar.setTitle("오픈채팅");
            } else if (item.getItemId() == R.id.tab4) {
                actionBar.setTitle("쇼핑");
            } else if (item.getItemId() == R.id.tab5) {
                actionBar.setTitle("더보기");
            } else {
                return false;
            }
            if (fragment == null) {
                Toast.makeText(this, "아직 메뉴가 준비되지 않았습니다.", Toast.LENGTH_SHORT).show();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }

            return true;
        }); // 람다식 메소드가 이해 안간다면 new를 통해서 interface 구조를 먼저 확인해볼 것
    }
}