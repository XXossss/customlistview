package com.bwei.customlistview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwei.customlistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boss on 2016/11/2.
 */
public class MyAdapter extends BaseAdapter {

    List<Boolean> linkedList=new ArrayList<>();
    private Context context;
    private List<String> list;
//    private boolean isHide;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list=list;
//        this.isHide = isHide;
        for (int i = 0; i < list.size(); i++) {
            linkedList.add(false);
        }
    }

    //对外提供一个方法 获取这个集合
    public List<Boolean> getSelect() {
        return linkedList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view=View.inflate(context, R.layout.item,null);

        }
        TextView tv= (TextView) view.findViewById(R.id.item_tv);
        tv.setText(list.get(i).toString());
        CheckBox cb= (CheckBox) view.findViewById(R.id.item_cb);
        cb.setChecked(linkedList.get(i));
        //对checkBox点击进行监听
        cb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //点中的时候改成相反的值
                linkedList.set(i, ! linkedList.get(i));
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
