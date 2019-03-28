package com.example.shivam.customviewsdemo.custom_views

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.shivam.customviewsdemo.R

class PageIndicatorView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()

    private var radius = 0.0f

    private val animator = ValueAnimator.ofFloat(0f, 90f)


    init {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.PageIndicatorView)
        var count = typedArray?.getInt(R.styleable.PageIndicatorView_piv_count, 0) ?: 0

        typedArray?.recycle()

        animator.setDuration(1000)

        animator.addUpdateListener {
            radius = it.getAnimatedValue() as Float
            invalidate()
        }

        animator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val x = width/2f
        val y = height/2f

        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        canvas?.drawCircle(x, y, radius, paint)
    }


}