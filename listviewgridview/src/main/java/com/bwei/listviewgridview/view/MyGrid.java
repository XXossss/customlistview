package com.bwei.listviewgridview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by boss on 2016/11/3.
 */
public class MyGrid extends GridView {
    public MyGrid(Context context) {
        super(context);
    }

    public MyGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expanSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expanSpec);
    }
}
