package com.example.androidem

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random

class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progress = 0f
    private var color = getRandomColor()
    private var shouldReset = false

    private val fillPaint = Paint().apply {
        style = Paint.Style.FILL
        this.color = this@ProgressView.color
    }

    private val borderPaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 2f
        color = Color.BLACK
    }

    init {
        setOnClickListener {
            updateProgress()
        }
    }

    private fun updateProgress() {
        if (shouldReset) {
            progress = 0f
            shouldReset = false
        } else {
            progress += 0.1f
            if (progress >= 1f) {
                progress = 1f
                shouldReset = true
            }
        }

        color = getRandomColor()
        fillPaint.color = color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()

        canvas.drawRect(0f, 0f, width, height, borderPaint)

        val fillWidth = width * progress

        if (fillWidth > 0) {
            canvas.drawRect(0f, 0f, fillWidth, height, fillPaint)
        }
    }

    private fun getRandomColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }
}