package com.example.recyclerviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbin
 * @date 2020/11/6
 */
public class MyAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private static final int VIEW_TYPE_3 = 3;

    private ArrayList<Member> mData;
    private Context mContext;

    public MyAdapter(ArrayList<Member> data, Context context) {
        mData = data;
        mContext = context;
        map.put(1, false);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_1:
                return new ViewHolderType1(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false));
            case VIEW_TYPE_2:
                return new ViewHolderType2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_2, parent, false));
            case VIEW_TYPE_3:
                return new ViewHolderType3(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_3, parent, false));
            default:
                Log.d("error", "ViewHolder is null");
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_1:
                // (ViewHolderType1) holder.bindViewHolder(position)
                bindViewHolder1((ViewHolderType1) holder, mData.get(position));
                break;
            case VIEW_TYPE_2:
                bindViewHolder2((ViewHolderType2) holder, mData.get(position));
                break;
            case VIEW_TYPE_3:
                bindViewHolder3((ViewHolderType3) holder, mData.get(position));
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType() == Member.Type.ONE) {
            return VIEW_TYPE_1;
        } else if (mData.get(position).getType() == Member.Type.TWO) {
            return VIEW_TYPE_2;
        } else if (mData.get(position).getType() == Member.Type.THREE) {
            return VIEW_TYPE_3;
        } else {
            return 0;
        }
    }

    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    Map<Integer, Boolean> map = new HashMap();

    private void bindViewHolder3(final ViewHolderType3 holder, Member member) {
        if (count3++ == 0) {
            holder.rlHead.setVisibility(View.VISIBLE);
        }
        holder.tvType.setText(String.valueOf(member.getType()));
        holder.tvName.setText(member.getName());
        holder.tvPhone.setText(member.getPhone());
        holder.tvHide.setOnClickListener(v -> holder.setVisibility(View.GONE));
    }

    private void bindViewHolder2(final ViewHolderType2 holder, Member member) {
        if (count2++ == 0) {
            holder.rlHead.setVisibility(View.VISIBLE);
        }
        holder.tvName.setText(member.getName());
        holder.tvPhone.setText(member.getPhone());
        holder.tvHide.setOnClickListener(v -> holder.setVisibility(View.GONE));
    }

    private void bindViewHolder1(ViewHolderType1 holder, Member member) {
        holder.setVisibility(map.get(member.getType()) ? View.GONE : View.VISIBLE);
        if (count1++ == 0) {
            holder.setVisibility(View.VISIBLE);
            holder.rlHead.setVisibility(View.VISIBLE);
            holder.tvName.setVisibility(map.get(member.getType()) ? View.GONE : View.VISIBLE);
        }
        holder.tvName.setText(member.getName());
        holder.tvHide.setOnClickListener(v -> {
            boolean isGone = map.get(member.getType());
            map.put(member.getType(), !isGone);
            holder.tvHide.setText(isGone ? "隐藏" : "展开");
            notifyDataSetChanged();
            count1 = 0;
        });
    }

}
