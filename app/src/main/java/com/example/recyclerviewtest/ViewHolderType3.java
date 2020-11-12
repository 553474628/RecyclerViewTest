package com.example.recyclerviewtest;

import android.view.View;
import android.widget.RelativeLayout;
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
    TextView tvHide;
    RelativeLayout rlHead;

    public ViewHolderType3(@NonNull View itemView) {
        super(itemView);
        tvType = itemView.findViewById(R.id.type);
        tvName = itemView.findViewById(R.id.name);
        tvPhone = itemView.findViewById(R.id.phone);
        tvHide = itemView.findViewById(R.id.hide);
        rlHead = itemView.findViewById(R.id.head);
    }

    public void setVisibility(int visibility) {
        itemView.setVisibility(visibility);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        if (visibility == View.VISIBLE) {
            params.width = RecyclerView.LayoutParams.MATCH_PARENT;
            params.height = RecyclerView.LayoutParams.WRAP_CONTENT;
        } else {
            params.width = 0;
            params.height = 0;
        }
        itemView.setLayoutParams(params);
    }
}
