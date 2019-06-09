package com.devfatani.twittertutorial.accessories

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable

object Shaper {
    fun getShape(
        borderWidth: Int = 0,
        borderColor: Int = 0xfffffffff.toInt(),
        cornerRadius: Float = 0f,
        bgColor: Int = 0
    ): GradientDrawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.setStroke(borderWidth, borderColor)
        shape.cornerRadius = cornerRadius
        if (bgColor != 0) {
            shape.color = ColorStateList.valueOf(bgColor)
        }
        return shape
    }
}