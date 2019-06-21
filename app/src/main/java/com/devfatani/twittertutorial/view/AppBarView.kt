package com.devfatani.twittertutorial.view

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.RelativeLayout
import com.devfatani.twittertutorial.R
import com.devfatani.twittertutorial.accessories.*
import de.hdodenhof.circleimageview.CircleImageView

class AppBarView(context: Context) : RelativeLayout(context) {
    private val rightIconFeed = TextView(context).apply {
        typeface = FontType.getFont(context, FontsName.FONTELLO)
        text = String(Character.toChars(0xE806))
        setTextColor(0xff2DA5EC.toInt())
        gravity = Gravity.CENTER
        textSize = Dimension.getSystemSize(context, 8f, Dimension.Unit.SP)
    }

    private val title = TextView(context).apply {
        text = "Home"
        setTypeface(null, Typeface.BOLD)
        textSize = 18f
        setTextColor(Color.BLACK)
        gravity = Gravity.CENTER
    }

    private val leftProfileImage = CircleImageView(context).apply {
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cat_profile))
    }

    private val bottomLine = View(context).apply {
        setBackgroundColor(Color.LTGRAY)
    }

    init {
        setBackgroundColor(Color.WHITE)
        layoutDirection = View.LAYOUT_DIRECTION_LTR

        //layout
        val rightIconFeedParams = Dimension.getRLayoutParams(
            numericWidth = Dimension.getSystemSize(context, 50f, Dimension.Unit.DP).toInt(),
            height = Dimension.Type.FILL
        )
        rightIconFeedParams.addRule(ALIGN_PARENT_RIGHT)
        rightIconFeed.layoutParams = rightIconFeedParams

        val titleParams = Dimension.getRLayoutParams(
            width = Dimension.Type.WRAP,
            height = Dimension.Type.FILL
        )
        titleParams.addRule(CENTER_IN_PARENT)
        title.layoutParams = titleParams


        val leftProfileImageParams = Dimension.getRLayoutParams(
            numericWidth = Dimension.getSystemSize(context, 35f, Dimension.Unit.DP).toInt(),
            numericHeight = Dimension.getSystemSize(
                context, 35f, Dimension.Unit.DP
            ).toInt()
        )
        leftProfileImageParams.setMargins(
            Dimension.getSystemSize(context, 15f, Dimension.Unit.DP).toInt(),
            Dimension.getSystemSize(context, 10f, Dimension.Unit.DP).toInt(),
            0,
            0
        )
        leftProfileImage.layoutParams = leftProfileImageParams

        val bottomLineParams = Dimension.getRLayoutParams(
            width = Dimension.Type.FILL,
            numericHeight = Dimension.getSystemSize(context, 1f, Dimension.Unit.DP).toInt()
        )
        bottomLineParams.addRule(ALIGN_PARENT_BOTTOM)
        bottomLine.layoutParams = bottomLineParams

        layoutParams = Dimension.getRLayoutParams(
            width = Dimension.Type.FILL,
            numericHeight = Dimension.getSystemSize(context, 50f, Dimension.Unit.DP).toInt()
        )
        addView(rightIconFeed)
        addView(title)
        addView(leftProfileImage)
        addView(bottomLine)
    }

    fun setLeftProfileImageAction(action: () -> Unit) {
        leftProfileImage.setOnClickListener { action() }
    }
}