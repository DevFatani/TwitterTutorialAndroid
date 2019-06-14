package com.devfatani.twittertutorial.accessories


import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.util.DisplayMetrics


enum class LayoutParamsType(val value: Int) {
    FILL(value = ViewGroup.LayoutParams.MATCH_PARENT),
    WRAP(value = ViewGroup.LayoutParams.WRAP_CONTENT),
    NONE(0)
}


enum class SizeUnit(val value: Int) {
    DP(value = TypedValue.COMPLEX_UNIT_DIP),
    SP(value = TypedValue.COMPLEX_UNIT_SP)
}

object Dimension {
    fun getSystemSize(context: Context, size: Float, unit: SizeUnit) =
        TypedValue.applyDimension(
            unit.value,
            size,
            context.resources.displayMetrics
        )

    fun getViewParams(
        width: LayoutParamsType = LayoutParamsType.NONE,
        height: LayoutParamsType = LayoutParamsType.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0
    ): ViewGroup.LayoutParams =
        ViewGroup.LayoutParams(
            if (width != LayoutParamsType.NONE) width.value else numericWidth,
            if (height != LayoutParamsType.NONE) height.value else numericHeight
        )

    fun getRLayoutParams(
        width: LayoutParamsType = LayoutParamsType.NONE,
        height: LayoutParamsType = LayoutParamsType.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0
    ): RelativeLayout.LayoutParams =
        RelativeLayout.LayoutParams(
            if (width != LayoutParamsType.NONE) width.value else numericWidth,
            if (height != LayoutParamsType.NONE) height.value else numericHeight
        )


    fun getLLayoutParams(
        width: LayoutParamsType = LayoutParamsType.NONE,
        height: LayoutParamsType = LayoutParamsType.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0,
        weight: Float = 0f
    ): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(
            if (width != LayoutParamsType.NONE) width.value else numericWidth,
            if (height != LayoutParamsType.NONE) height.value else numericHeight,
            weight
        )

    fun getFrameLayoutParams(
        width: LayoutParamsType = LayoutParamsType.NONE,
        height: LayoutParamsType = LayoutParamsType.NONE,
        numericWidth: Int = 0,
        numericHeight: Int = 0,
        gravity: Int = 0
    ): FrameLayout.LayoutParams =
        FrameLayout.LayoutParams(
            if (width != LayoutParamsType.NONE) width.value else numericWidth,
            if (height != LayoutParamsType.NONE) height.value else numericHeight,
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