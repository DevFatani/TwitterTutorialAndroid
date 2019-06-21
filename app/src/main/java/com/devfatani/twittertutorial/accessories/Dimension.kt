package com.devfatani.twittertutorial.accessories

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.util.DisplayMetrics

object Dimension {
    enum class Type(val value: Int) {
        FILL(value = ViewGroup.LayoutParams.MATCH_PARENT),
        WRAP(value = ViewGroup.LayoutParams.WRAP_CONTENT),
        NONE(0)
    }


    enum class Unit(val value: Int) {
        DP(value = TypedValue.COMPLEX_UNIT_DIP),
        SP(value = TypedValue.COMPLEX_UNIT_SP)
    }


    fun getSystemSize(context: Context, size: Float, unit: Unit) =
        TypedValue.applyDimension(
            unit.value,
            size,
            context.resources.displayMetrics
        )

    fun getViewParams(
        width: Type = Type.NONE,
        height: Type = Type.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0
    ): ViewGroup.LayoutParams =
        ViewGroup.LayoutParams(
            if (width != Type.NONE) width.value else numericWidth,
            if (height != Type.NONE) height.value else numericHeight
        )

    fun getRLayoutParams(
        width: Type = Type.NONE,
        height: Type = Type.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0
    ): RelativeLayout.LayoutParams =
        RelativeLayout.LayoutParams(
            if (width != Type.NONE) width.value else numericWidth,
            if (height != Type.NONE) height.value else numericHeight
        )


    fun getLLayoutParams(
        width: Type = Type.NONE,
        height: Type = Type.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0,
        weight: Float = 0f
    ): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(
            if (width != Type.NONE) width.value else numericWidth,
            if (height != Type.NONE) height.value else numericHeight,
            weight
        )

    fun getFrameLayoutParams(
        width: Type = Type.NONE,
        height: Type = Type.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0,
        gravity: Int = 0
    ): FrameLayout.LayoutParams =
        FrameLayout.LayoutParams(
            if (width != Type.NONE) width.value else numericWidth,
            if (height != Type.NONE) height.value else numericHeight,
            gravity
        )

    fun getScreenSize(activity: Activity): Pair<Int, Int> {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        return Pair(height, width)
    }

}