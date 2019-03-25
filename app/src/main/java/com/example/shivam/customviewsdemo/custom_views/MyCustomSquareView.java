package com.example.shivam.customviewsdemo.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.shivam.customviewsdemo.R;

public class MyCustomSquareView extends View {
    private Paint mPaint;
    private Rect mRect;
    private int mRectColor;
    private int mPadding;
    private String mToastMsg = "";
    private Toast mlimitToast = Toast.makeText(getContext(), mToastMsg, Toast.LENGTH_SHORT);

    public MyCustomSquareView(Context context) {
        super(context);
        init(null);
    }

    public MyCustomSquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyCustomSquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MyCustomSquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();

        if (set == null) {
            return;
        }

        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.MyCustomSquareView);

        mRectColor = typedArray.getColor(R.styleable.MyCustomSquareView_rectColor, Color.BLACK);

        typedArray.recycle();

    }

    public void setCustomPadding(int padding) {

        if (mPadding <= 0 & padding < 0){
            mlimitToast.cancel();
            mToastMsg = "Padding meets the upper limits.";
            mlimitToast = Toast.makeText(getContext(), mToastMsg, Toast.LENGTH_SHORT);
            mlimitToast.show();
            return;
        } else if (mPadding >= 150 && padding > 0) {
            mlimitToast.cancel();
            mToastMsg = "Padding meets the lower limits.";
            mlimitToast = Toast.makeText(getContext(), mToastMsg, Toast.LENGTH_SHORT);
            mlimitToast.show();
            return;
        }
        mPadding = mPadding + padding;
        postInvalidate();
    }

    public void swapColor(boolean colorDefault){
        mRectColor = colorDefault ? Color.BLACK : Color.RED;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(mRectColor);

        mRect.top = 0 + mPadding;
        mRect.right = getWidth() - mPadding;
        mRect.bottom = getHeight() - mPadding;
        mRect.left = 0 + mPadding;

        canvas.drawRect(mRect, mPaint);
    }
}
