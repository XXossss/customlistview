package com.bwei.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.bwei.customlistview.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data=new String[]{"数据","使用数组添加","使用for循环","将数组中的数据添加到集合","找出listview控件","进行适配","适配中创建一个集合，相当于备份","找出子布局的控件进行赋值","在主方法单点事件","进行判断"};
    private ListView lv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initView() {

        lv = (ListView) findViewById(R.id.lv);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);

    }

    private void initData() {

        List<String> list=new ArrayList<>();
        for (int i=0;i<data.length;i++){

            list.add(data[i]);

        }
        adapter = new MyAdapter(MainActivity.this,list);
        lv.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn:
                for (int i = 0; i < adapter.getSelect().size(); i++) {
                    adapter.getSelect().set(i, true);
                }
                adapter.notifyDataSetChanged();
                break;

            case R.id.btn2:
                break;

            case R.id.btn3:
                for (int i = 0; i < adapter.getSelect().size(); i++) {
                    adapter.getSelect().set(i, false);
                }
                adapter.notifyDataSetChanged();
                break;


        }
    }
}
