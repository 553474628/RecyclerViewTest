package com.example.recyclerviewtest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenbin
 * @date 2020/11/6
 */
public class ViewHolderType2 extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvPhone;

    public ViewHolderType2(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.name);
        tvPhone = itemView.findViewById(R.id.phone);
    }

    public void bindViewHolder(Member member) {
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
    }
}
