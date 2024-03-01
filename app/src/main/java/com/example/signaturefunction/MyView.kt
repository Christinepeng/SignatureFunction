package com.example.signaturefunction

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.util.*
import kotlin.collections.HashMap

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
//    private val lines = LinkedList<LinkedList<HashMap<String, Float>>>()
    private val line = LinkedList<HashMap<String, Float>>()
    private val paint = Paint()

    init {
        Log.v("zz", "set paint")
        paint.setColor(Color.BLUE)
        paint.strokeWidth= 9F
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.v("zz", "onDraw()")

//        lines.forEach {
            for (i in 1..<line.size) {
                val p0 = line[i - 1]
                val p1 = line[i]
                canvas.drawLine(p0["x"]!!, p0["y"]!!, p1["x"]!!, p1["y"]!!, paint)
            }
//        }

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
//        Log.v("zz", "set paint in onTouchEvent()")
//        paint.setColor(Color.BLUE)
//        paint.strokeWidth = 8F
        when (event.action) {
            MotionEvent.ACTION_DOWN -> setFirstPoint(event)
            MotionEvent.ACTION_MOVE -> setMovePoint(event)
        }

//        if (event.action == MotionEvent.ACTION_DOWN) {
//            Log.v("zz", "down")
//            setFirstPoint(event)
//        } else if (event.action == MotionEvent.ACTION_UP) {
//            Log.v("zz", "up")
//        } else if (event.action == MotionEvent.ACTION_MOVE) {
//            Log.v("zz", "move")
//            setMovePoint(event)
//        }
//        val ret = super.onTouchEvent(event)
        return true
    }

    private fun setFirstPoint(event: MotionEvent) {
        Log.v("zz", "setFirstPoint()")
//        val line = LinkedList<HashMap<String, Float>>()

        val ex = event.x
        val ey = event.y
        val point = HashMap<String, Float>()
        point["x"] = ex
        point["y"] = ey
        line.add(point)

//        lines.add(line)
    }

    private fun setMovePoint(event: MotionEvent) {
        Log.v("zz", "setMovePoint()")
        val ex = event.x
        val ey = event.y
        val point = HashMap<String, Float>()
        point["x"] = ex
        point["y"] = ey
        line.add(point)
//        lines.last.add(point)

        invalidate()
    }
}