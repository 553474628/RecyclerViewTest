package com.example.recyclerviewtest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenbin
 * @date 2020/11/9
 */
public class ViewHolderType4 extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvHide;

    public ViewHolderType4(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.name);
        tvHide = itemView.findViewById(R.id.hide);
    }

    public void bindViewHolder(Member member, OnHideClickListener listener) {
        tvName.setText(member.getName());
        tvHide.setOnClickListener(v -> {
            if (listener != null) {
                member.setHide(!member.isHide());
                boolean isHide = member.isHide();
                tvHide.setText(isHide ? "展开" : "隐藏");
                listener.onHideClick(member.getLevel(), isHide);
            }
        });
    }

}
