package com.bwei.listviewgridview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.listviewgridview.R;

import java.util.List;

/**
 * Created by boss on 2016/11/3.
 */
public class MyListAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public MyListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view=View.inflate(context, R.layout.list_item,null);
        }
        TextView list_item_tv= (TextView) view.findViewById(R.id.list_item_tv);
        list_item_tv.setText(list.get(i).toString());
        return view;
    }
}
