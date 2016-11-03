package com.bwei.listviewgridview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.listviewgridview.R;

import java.util.List;

/**
 * Created by boss on 2016/11/3.
 */
public class MyGridAdapter extends BaseAdapter{

    private List<Integer> list;
    private Context context;

    public MyGridAdapter(List<Integer> list, Context context) {
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

            view=View.inflate(context, R.layout.grid_item,null);

        }

        ImageView grid_item_img= (ImageView) view.findViewById(R.id.grid_item_img);
        grid_item_img.setImageResource(list.get(i));
        TextView grid_item_tc= (TextView) view.findViewById(R.id.grid_item_tc);
        grid_item_tc.setText("协议"+i);
        return view;
    }
}
