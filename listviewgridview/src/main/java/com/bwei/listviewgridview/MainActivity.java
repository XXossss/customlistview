package com.bwei.listviewgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import com.bwei.listviewgridview.adapter.MyGridAdapter;
import com.bwei.listviewgridview.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] img=new int[]{R.mipmap.gv1,R.mipmap.gv2,R.mipmap.gv3,R.mipmap.gv4,R.mipmap.gv5,R.mipmap.gv6,R.mipmap.gv7,R.mipmap.gv8,R.mipmap.gv9,R.mipmap.gv10,R.mipmap.gv11,R.mipmap.gv12,R.mipmap.gv13,R.mipmap.gv14,R.mipmap.gv14,R.mipmap.gv14};
    private GridView gv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        List<Integer> grid_list=new ArrayList<>();
        for (int i=0;i<img.length;i++){
            grid_list.add(img[i]);
        }
        gv.setAdapter(new MyGridAdapter(grid_list,MainActivity.this));
        List<String> lv_list=new ArrayList<>();
        for (int j=0;j<20;j++){

            lv_list.add("这是listviewitem条目"+j);

        }
        lv.setAdapter(new MyListAdapter(lv_list,MainActivity.this));
    }

    private void initView() {

        gv = (GridView) findViewById(R.id.gv);
        lv = (ListView) findViewById(R.id.lv);

    }
}
