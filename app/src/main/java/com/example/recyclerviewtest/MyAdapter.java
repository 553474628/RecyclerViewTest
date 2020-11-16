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
    private static final int VIEW_TYPE_4 = 4;

    private ArrayList<Member> mData;
    private Context mContext;

    private OnHideClickListener mListener;

    public void setListener(OnHideClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(ArrayList<Member> data, Context context) {
        mData = data;
        mContext = context;
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
            case VIEW_TYPE_4:
                return new ViewHolderType4(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_4, parent, false));
            default:
                Log.d("error", "ViewHolder is null");
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_1:
                ((ViewHolderType1) holder).bindViewHolder(mData.get(position));
                break;
            case VIEW_TYPE_2:
                ((ViewHolderType2) holder).bindViewHolder(mData.get(position));
                break;
            case VIEW_TYPE_3:
                ((ViewHolderType3) holder).bindViewHolder(mData.get(position));
                break;
            case VIEW_TYPE_4:
                ((ViewHolderType4) holder).bindViewHolder(mData.get(position), mListener);
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
        } else if (mData.get(position).getType() == Member.Type.FOUR) {
            return VIEW_TYPE_4;
        } else {
            return 0;
        }
    }
}
