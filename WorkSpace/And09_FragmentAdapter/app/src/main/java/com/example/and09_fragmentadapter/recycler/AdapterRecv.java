package com.example.and09_fragmentadapter.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

// 2. extends로 AdapterClass를 상속받는다
// 상속을 받을 때 ViewHolder가 필요함. RecyclerView.Adapter<VH> => VH : ViewHolder
public class AdapterRecv extends RecyclerView.Adapter<AdapterRecv.KhmViewHolder> {

    LayoutInflater inflater;
    ArrayList<RecvDTO> list;

    public AdapterRecv(LayoutInflater inflater, ArrayList<RecvDTO> list) {
        this.inflater = inflater;
        this.list= list;
    }

    // 레이아웃을 붙이고 (View) 해당하는 타입으로 ViewHolder를 만들어내는 과정의 메소드
    @NonNull
    @Override
    public KhmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv, parent, false);
        return new KhmViewHolder(v);
    }

    // ViewHolder와 Data 연결 (디자인 <==> ArrayList)
    @Override
    public void onBindViewHolder(@NonNull KhmViewHolder holder, int i) {
        holder.imgv_profile.setImageResource(list.get(i).getImgRes());
        holder.tv_name.setText(list.get(i).getName());
        holder.tv_addr.setText(list.get(i).getAddr());
        holder.tv_age.setText(list.get(i).getAge() + "");
        holder.tv_gender.setText(list.get(i).getGender());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 1. InnerClass로 ViewHolder를 먼저 만든다.
    // 위젯들을 묶어놓은 DTO라고 생각하면 됨. 리사이클러뷰는 ViewHolder를 강제한다. (재활용)
    // ViewHolder는 일반 InnerClass에 RecyclerView.ViewHolder를 상속받은 구조
    public class KhmViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_profile;
        TextView tv_gender, tv_name, tv_age, tv_addr;
        Button btn_detail;
        public KhmViewHolder(@NonNull View v) {
            super(v);
            imgv_profile = v.findViewById(R.id.imgv_profile);
            tv_gender = v.findViewById(R.id.tv_gender);
            tv_name = v.findViewById(R.id.tv_name);
            tv_age = v.findViewById(R.id.tv_age);
            tv_addr = v.findViewById(R.id.tv_addr);
            btn_detail = v.findViewById(R.id.btn_detail);
        }
    }
}
