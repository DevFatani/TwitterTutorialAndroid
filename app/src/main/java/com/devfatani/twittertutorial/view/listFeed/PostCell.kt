package com.devfatani.twittertutorial.view.listFeed

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.devfatani.twittertutorial.accessories.*
import com.devfatani.twittertutorial.model.Post
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

@SuppressLint("ViewConstructor")
class PostCell(context: Context, post: Post) : LinearLayout(context) {
    private val ivUserImageProfile = CircleImageView(context).apply {
        val dim50 = Dimension.getSystemSize(context, 50f, Dimension.Unit.DP).toInt()
        Picasso
            .get()
            .load(post.user.avatar).resize(dim50, dim50)
            .centerInside()
            .into(this)
        layoutParams = Dimension.getLLayoutParams(
            numericWidth = dim50,
            numericHeight = dim50
        )
    }

    private val tvUserAccountName = TextView(context).apply {
        text = post.user.userAccount
        setTextColor(Color.BLACK)
        setTypeface(null, Typeface.BOLD)
//        setBackgroundColor(Color.BLUE)
    }

    private val tvUsername = TextView(context).apply {
        text = "@${post.user.username}"
        setTextColor(Color.DKGRAY)

        val params = Dimension.getFrameLayoutParams(
            width = Dimension.Type.WRAP,
            height = Dimension.Type.WRAP
        )

        params.setMargins(
            Dimension.getSystemSize(context, 4f, Dimension.Unit.DP).toInt(),
            0,
            Dimension.getSystemSize(context, 4f, Dimension.Unit.DP).toInt(),
            0
        )
        layoutParams = params
    }

    private val tvTime = TextView(context).apply {
        text = post.time
        setTextColor(Color.DKGRAY)
    }

    private val tvPost = TextView(context).apply {
        text = post.body
        setLineSpacing(20f, 1.0f)
        setTextColor(Color.BLACK)
        setPadding(0, 0, Dimension.getSystemSize(context, 5f, Dimension.Unit.DP).toInt(), 0)
    }

    private val tvShareIcon = TextView(context).apply {
        text = String(Character.toChars(0xE803))
        typeface = FontType.getFont(context, FontsName.FONTELLO)
        textSize = 19f
        setTextColor(Color.DKGRAY)

        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.WRAP,
            weight = 1f
        )
    }

    private val reply = IconWithCountNumber(context, 0xE802, post.numOfReply).apply {
        if (post.isCurrentUserReply) {
            setIconActive()
        } else {
            setIconInActive()
        }

        setOnClickListener {
            if (!post.isCurrentUserReply) {
                val newReply = post.numOfReply + 1
                post.numOfReply = newReply
                post.isCurrentUserReply = true
                this.setIconActive()
                this.setNewCount(newReply)
            } else {
                val newReply = post.numOfReply - 1
                post.numOfReply = newReply
                post.isCurrentUserReply = false
                this.setIconInActive()
                this.setNewCount(newReply)
            }
        }

        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.WRAP,
            weight = 1f
        )
    }

    private val reTweet = IconWithCountNumber(context, 0xE801, post.numOfReTweet).apply {
        if (post.isCurrentUserReTweet) {
            setIconActive()
        } else {
            setIconInActive()
        }

        setOnClickListener {
            if (!post.isCurrentUserReTweet) {
                val newReTweet = post.numOfReTweet + 1
                post.numOfReTweet = newReTweet
                post.isCurrentUserReTweet = true
                this.setIconActive()
                this.setNewCount(newReTweet)
            } else {
                val newReTweet = post.numOfReTweet - 1
                post.numOfReTweet = newReTweet
                post.isCurrentUserReTweet = false
                this.setIconInActive()
                this.setNewCount(newReTweet)
            }
        }

        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.WRAP,
            weight = 1f
        )
    }

    private val favorite = IconWithCountNumber(context, 0xE800, post.numOfFavorite).apply {

        if (post.isCurrentUserFavorite) {
            setIconActive()
        } else {
            setIconInActive()
        }

        setOnClickListener {
            if (!post.isCurrentUserFavorite) {
                val newFavorite = post.numOfFavorite + 1
                post.numOfFavorite = newFavorite
                post.isCurrentUserFavorite = true
                this.setIconActive()
                this.setNewCount(newFavorite)
            } else {
                val newFavorite = post.numOfFavorite - 1
                post.numOfFavorite = newFavorite
                post.isCurrentUserFavorite = false
                this.setIconInActive()
                this.setNewCount(newFavorite)
            }
        }

        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.WRAP,
            weight = 1f
        )

    }

    private val separatorLine = View(context).apply {
        setBackgroundColor(Color.LTGRAY)
        layoutParams = Dimension.getLLayoutParams(
            width = Dimension.Type.FILL,
            numericHeight = Dimension.getSystemSize(context, 1f, Dimension.Unit.DP).toInt()
        )
    }

    // containers
    private val verticalContainer = LinearLayout(context).apply {
        weightSum = 2f
    }

    private val leftContainer = LinearLayout(context).apply {
        setPadding(
            Dimension.getSystemSize(
                context, 10f, Dimension.Unit.DP
            ).toInt(),
            Dimension.getSystemSize(context, 5f, Dimension.Unit.DP).toInt(),
            0,
            0
        )
        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.FILL,
            weight = 0.4f
        )
    }

    private val rightContainer = LinearLayout(context).apply {
        orientation = VERTICAL
        layoutParams = Dimension.getLLayoutParams(
            numericWidth = 0,
            height = Dimension.Type.FILL,
            weight = 1.6f
        )
    }

    private val userContainer = LinearLayout(context)

    private val iconsContainer = LinearLayout(context).apply {
        gravity = Gravity.CENTER
        layoutParams = Dimension.getLLayoutParams(
            width = Dimension.Type.FILL,
            numericHeight = Dimension.getSystemSize(context, 40f, Dimension.Unit.DP).toInt()
        )
    }

    init {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.WHITE)
        layoutDirection = View.LAYOUT_DIRECTION_LTR

        setPadding(0, Dimension.getSystemSize(context, 10f, Dimension.Unit.DP).toInt(), 0, 0)
        layoutParams = Dimension.getLLayoutParams(
            width = Dimension.Type.FILL,
            height = Dimension.Type.WRAP
        )

        leftContainer.addView(ivUserImageProfile)

        userContainer.addView(tvUserAccountName)
        userContainer.addView(tvUsername)
        userContainer.addView(tvTime)


        iconsContainer.addView(reply)
        iconsContainer.addView(reTweet)
        iconsContainer.addView(favorite)
        iconsContainer.addView(tvShareIcon)

        rightContainer.addView(userContainer)
        rightContainer.addView(tvPost)
        rightContainer.addView(iconsContainer)

        verticalContainer.addView(leftContainer)
        verticalContainer.addView(rightContainer)

        addView(verticalContainer)
        addView(separatorLine)

    }

}

