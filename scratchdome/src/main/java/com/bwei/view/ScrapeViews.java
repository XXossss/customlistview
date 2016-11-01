package com.bwei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.bwei.scratchdome.R;

/**
 * Created by boss on 2016/11/1.
 */
public class ScrapeViews extends View {


    private int circleColor;
    private int arcColor;
    private int textColor;
    private float textSize;
    private String text;
    private int startAngle;
    private int sweepAngle;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private RectF mRectF;

    public ScrapeViews(Context context) {
        super(context);
    }


    public ScrapeViews(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ScrapeViews
        );
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.ScrapeViews_circleColor, 0);
            arcColor = ta.getColor(R.styleable.ScrapeViews_arcColor, 0);
            textColor = ta.getColor(R.styleable.ScrapeViews_textColor, 0);
            textSize = ta.getDimension(R.styleable.ScrapeViews_textSize, 50);
            text = ta.getString(R.styleable.ScrapeViews_text);
            startAngle = ta.getInt(R.styleable.ScrapeViews_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.ScrapeViews_sweepAngle, 270);
            ta.recycle();
        }

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init(w,h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
       canvas.drawText("韩炎兵", mCircleXY, mCircleXY + textSize
               / 4, mTextPaint);
    }

    private void init(int width,int height) {
        int length = Math.min(width, height);
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.RED);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((width * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

}
