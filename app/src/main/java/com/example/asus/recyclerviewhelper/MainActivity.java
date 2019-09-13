package com.example.asus.recyclerviewhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.asus.recyclerviewhelper.libs.MultiSnapRecyclerViewHelper;
import com.example.asus.recyclerviewhelper.libs.SnapGravity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> mDataS = new ArrayList<>(Arrays.asList(R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item6));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView recycler = findViewById(R.id.recycler);
        MyAdapter adapter = new MyAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(manager);
        adapter.updateDatas(mDataS);
        new MultiSnapRecyclerViewHelper.Builder(this)
                .setGraVity(SnapGravity.CENTER)
                .setMilliSecondsPerInch(30)
                .setSnapCount(1)
                .build()
                .attachToRecyclerView(recycler);
    }
}
