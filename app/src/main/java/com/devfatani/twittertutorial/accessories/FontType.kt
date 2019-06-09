package com.devfatani.twittertutorial.accessories

import android.content.Context
import android.graphics.Typeface

object FontType {
    fun getFont(context: Context, fontName: String): Typeface =
        Typeface.create(
            Typeface.createFromAsset(context.assets, "fonts/$fontName"),
            Typeface.NORMAL
        )
}