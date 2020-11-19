package com.example.recyclerviewtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenbin
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private ArrayList<Member> mData = new ArrayList<>();
    private Map<Integer, List<Member>> mHashMap = new LinkedHashMap<>();

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
                    addData(type);
                }
                refreshData();
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
    List<Member> list4 = new ArrayList<>();
    List<Member> list5 = new ArrayList<>();
    List<Member> list6 = new ArrayList<>();
    Member member4_1;
    Member member4_2;
    Member member4_3;

    private void initData() {

        member4_1 = new Member(4, 1, "VIP", "11111", false);
        list4.add(member4_1);
        member4_2 = new Member(4, 2, "VIP", "11111", false);
        list5.add(member4_2);
        member4_3 = new Member(4, 3, "VIP", "11111", false);
        list6.add(member4_3);

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
        mHashMap.put(1, list4);
        mHashMap.put(2, list1);
        mHashMap.put(3, list5);
        mHashMap.put(4, list2);
        mHashMap.put(5, list6);
        mHashMap.put(6, list3);

        refreshData();
    }

    private void removeData(int level) {
        switch (level) {
            case 1:
                mHashMap.put(2, new ArrayList<>());
                break;
            case 2:
                mHashMap.put(4, new ArrayList<>());
                break;
            case 3:
                mHashMap.put(6, new ArrayList<>());
                break;
            default:
                break;
        }
    }

    private void addData(int level) {
        switch (level) {
            case 1:
                mHashMap.put(2, list1);
                break;
            case 2:
                mHashMap.put(4, list2);
                break;
            case 3:
                mHashMap.put(6, list3);
                break;
            default:
                break;
        }
    }

    private void refreshData() {
        mData.clear();
        for (Integer key : mHashMap.keySet()) {
            mData.addAll(mHashMap.get(key));
        }
    }
}