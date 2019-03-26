package com.example.shivam.customviewsdemo.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.shivam.customviewsdemo.R

class PageIndicatorView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()

    init {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.PageIndicatorView)
        var count = typedArray?.getInt(R.styleable.PageIndicatorView_piv_count, 0) ?: 0

        typedArray?.recycle()
    }


//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//
//        var widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
//        var heightMode = MeasureSpec.getMode(heightMeasureSpec)
//        var heightSize = MeasureSpec.getSize(heightMeasureSpec)
//
//        when (widthMode) {
//            MeasureSpec.EXACTLY -> {
//
//            }
//            MeasureSpec.AT_MOST -> {
//
//            }
//            MeasureSpec.UNSPECIFIED -> {
//
//            }
//        }
//
//        when (heightMode) {
//            MeasureSpec.EXACTLY -> {
//
//            }
//            MeasureSpec.AT_MOST -> {
//
//            }
//            MeasureSpec.UNSPECIFIED -> {
//
//            }
//        }
//
//    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val x = width/2f
        val y = height/2f

        val radius = y

        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        canvas?.drawCircle(x, y, radius, paint)
    }


}