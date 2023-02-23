package com.qiaodan.jetpackdemo

/**
 * author: created by yuqiaodan on 2023/2/23 16:02
 * description:
 */
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BarChartView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var mDataList: List<Float> = listOf()
    private var mPaint: Paint = Paint()
    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLUE
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        val barWidth = width / mDataList.size
        for (i in mDataList.indices) {
            val left = i * barWidth
            val top = height - mDataList[i]
            val right = (i + 1) * barWidth
            val bottom = height
            canvas.drawRect(left, top, right, bottom, mPaint)
        }
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
    fun setDataList(dataList: List<Float>) {
        mDataList = dataList
        invalidate()
    }
}