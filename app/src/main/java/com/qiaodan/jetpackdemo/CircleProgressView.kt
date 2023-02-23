package com.qiaodan.jetpackdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author: created by yuqiaodan on 2023/2/23 15:59
 * description:
 */

class CircleProgressView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var mProgress = 0f
    private var mMaxProgress = 100f
    private var mPaint: Paint = Paint()
    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 10f
        mPaint.color = Color.BLUE
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(centerX, centerY)
        canvas.drawCircle(centerX, centerY, radius, mPaint)
        val angle = mProgress / mMaxProgress * 360
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, -90f, angle, false, mPaint)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
    fun setProgress(progress: Float) {
        mProgress = progress
        invalidate()
    }
}