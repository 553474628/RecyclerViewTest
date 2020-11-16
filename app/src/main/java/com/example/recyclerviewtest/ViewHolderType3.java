package com.example.recyclerviewtest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenbin
 * @date 2020/11/6
 */
public class ViewHolderType3 extends RecyclerView.ViewHolder {

    TextView tvType;
    TextView tvName;
    TextView tvPhone;

    public ViewHolderType3(@NonNull View itemView) {
        super(itemView);
        tvType = itemView.findViewById(R.id.type);
        tvName = itemView.findViewById(R.id.name);
        tvPhone = itemView.findViewById(R.id.phone);
    }

    public void bindViewHolder(Member member) {
        tvType.setText(String.valueOf(member.getType()));
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
    }
}
