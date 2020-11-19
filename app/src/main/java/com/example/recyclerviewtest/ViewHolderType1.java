package com.example.recyclerviewtest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenbin
 * @date 2020/11/6
 */
public class ViewHolderType1 extends RecyclerView.ViewHolder {

    TextView tvName;

    public ViewHolderType1(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.name);
    }

    public void bindViewHolder(Member member) {
        tvName.setText(member.getName());
    }
}
