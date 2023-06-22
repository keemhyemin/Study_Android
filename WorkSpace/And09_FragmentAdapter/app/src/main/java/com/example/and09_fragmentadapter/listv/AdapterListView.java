package com.example.and09_fragmentadapter.listv;


import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and09_fragmentadapter.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

// class 상속 : BaseAdapter라는 클래스
public class AdapterListView extends BaseAdapter {
    // 어댑터는 일반 클래스 + 기능이 있는 정도 ( 반드시 화면에 보인다는 맥락이 없음 ==> LayoutInflater, Toast 등의 기능 제한)
    // 어댑터는 LayoutInflater가 기본적으로 필요한데, 해당하는 객체를 상위(나를 사용하는 지역)에서 받아와야한다.
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public AdapterListView(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    // 몇개의 아이템이 반복되는지의 반복횟수 즉, 총 리스트의 개수
    @Override
    public int getCount() {
        return list.size();
    }

    // 목록을 보여줄 때 사용 된 Object(DTO)가 있다면 해당하는 DTO를 리턴하기위한 메소드
    @Override
    public Object getItem(int position) {
        return position;
    }

    // 아이템을 유일하게 식별할 수 있는 값인데 position 자체가 유일하기 때문에 그대로 return부를 바꿔준다.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // LayoutInflater를 이용해서 칸마다의 아이템을 붙이는 처리를 해줘야 함
    @Override
    public View getView(int i, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_listview, parent, false);
        ImageView img_profile = v.findViewById(R.id.imgv_profile);
        img_profile.setImageResource(list.get(i).getImgRes());
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_msg = v.findViewById(R.id.tv_msg);
        tv_name.setText(list.get(i).getName());
        tv_msg.setText(list.get(i).getMsg());
        return v;
    }
}
