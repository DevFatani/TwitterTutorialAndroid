package com.devfatani.twittertutorial.view.listFeed

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import com.devfatani.twittertutorial.accessories.*

@SuppressLint("ViewConstructor")
class IconWithCountNumber(context: Context, iconCode: Int, count: Int) : LinearLayout(context) {
    private val icon = TextView(context).apply {
        text = String(Character.toChars(iconCode))
        typeface = FontType.getFont(context, FontsName.FONTELLO)
        textSize = 19f
        setTextColor(Color.DKGRAY)
    }
    private val textView = TextView(context).apply {
        text = count.toString()
        setTextColor(Color.DKGRAY)

        val params = Dimension.getLLayoutParams(
            width = Dimension.Type.WRAP,
            height = Dimension.Type.WRAP
        )
        params.setMargins(
            Dimension.getSystemSize(context, 5f, Dimension.Unit.DP).toInt(),
            0,
            0,
            0
        )
        layoutParams = params
    }

    init {
        addView(icon)
        addView(textView)
    }

    fun setIconActive() {
        icon.setTextColor(Color.RED)
    }

    fun setIconInActive() {
        icon.setTextColor(Color.DKGRAY)
    }

    fun setNewCount(value:Int) {
        textView.text = value.toString()
    }
}