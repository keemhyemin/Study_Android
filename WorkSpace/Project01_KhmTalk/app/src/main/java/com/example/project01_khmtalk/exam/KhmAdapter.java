package com.example.project01_khmtalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class KhmAdapter extends KhmAdapterParent.KhmAdapter<KhmAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends KhmAdapterParent.KhmViewHolder {
        public ViewHolder(@NonNull View view) {
            super(view);
        }
    }

}
