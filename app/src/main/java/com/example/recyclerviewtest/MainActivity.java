package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbin
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Member> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(mData, this);
        mAdapter.setListener(new OnHideClickListener() {
            @Override
            public void onHideClick(int type, boolean hide) {
                if (hide) {
                    removeData(type);
                } else {
                    // 测试600的数据量没问题，但是当隐藏多个在展开的时候就会出现全部展开的问题（需要一种数据结构来完成）
                    mData.clear();
                    addAllDate();
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    List<Member> list1 = new ArrayList<>();
    List<Member> list2 = new ArrayList<>();
    List<Member> list3 = new ArrayList<>();
    Member member4_1;
    Member member4_2;
    Member member4_3;

    private void initData() {

        member4_1 = new Member(4, 1, "VIP", "11111", false);
        member4_2 = new Member(4, 2, "VIP", "11111", false);
        member4_3 = new Member(4, 3, "VIP", "11111", false);

        Member member1 = new Member(1, "陈彬", "1111111");
        Member member2 = new Member(1, "陈彬3", "176854465");
        list1.add(member1);
        list1.add(member2);

        Member member3 = new Member(2, "陈彬1", "2123123");
        Member member4 = new Member(2, "陈彬4", "243423135");
        list2.add(member3);
        list2.add(member4);

        Member member5 = new Member(3, "陈彬2", "35556657");
        Member member6 = new Member(3, "陈彬5", "33345456");
        Member member7 = new Member(3, "陈彬6", "33463463");
        list3.add(member5);
        list3.add(member6);
        list3.add(member7);

        addAllDate();
    }

    private void addAllDate() {
        mData.add(member4_1);
        mData.addAll(list1);
        mData.add(member4_2);
        mData.addAll(list2);
        mData.add(member4_3);
        mData.addAll(list3);
    }

    private void removeData(int level) {
        switch (level) {
            case 1:
                mData.removeAll(list1);
                break;
            case 2:
                mData.removeAll(list2);
                break;
            case 3:
                mData.removeAll(list3);
                break;
            default:
                break;
        }
    }

    private void addData(int level) {
        switch (level) {
            case 1:
                mData.addAll(list1);
                break;
            case 2:
                mData.addAll(list2);
                break;
            case 3:
                mData.addAll(list3);
                break;
            default:
                break;
        }
    }
}