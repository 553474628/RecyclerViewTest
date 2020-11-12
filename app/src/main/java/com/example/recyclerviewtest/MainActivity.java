package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Member> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter(mData, this);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        List<Member> list1 = new ArrayList<>();
        List<Member> list2 = new ArrayList<>();
        List<Member> list3 = new ArrayList<>();
        /*Member member = new Member(4, "VIP", "222");
        mData.add(member);*/
        Member member1 = new Member(1, "陈彬", "1111111");
        Member member2 = new Member(1, "陈彬3", "176854465");
        list1.add(member1);
        list1.add(member2);
        mData.addAll(list1);
        Member member3 = new Member(2, "陈彬1", "2123123");
        Member member4 = new Member(2, "陈彬4", "243423135");
        list2.add(member3);
        list2.add(member4);
        mData.addAll(list2);
        Member member5 = new Member(3, "陈彬2", "35556657");
        Member member6 = new Member(3, "陈彬5", "33345456");
        Member member7 = new Member(3, "陈彬6", "33463463");
        list3.add(member5);
        list3.add(member6);
        list3.add(member7);
        mData.addAll(list3);
    }
}