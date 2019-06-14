package com.devfatani.twittertutorial.view.slideView

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.devfatani.twittertutorial.R
import com.devfatani.twittertutorial.accessories.*
import de.hdodenhof.circleimageview.CircleImageView

@SuppressLint("ViewConstructor")
class SlideView(private val activity: Activity, private val container: View, val blackView: View) : FrameLayout(activity) {

    private var isOpen = false

    private val topRightIcon = TextView(context).apply {
        typeface = FontType.getFont(context, FontsName.FONTELLO)
        text = String(Character.toChars(0xE805))
        textSize = Dimension.getSystemSize(context, 8f, SizeUnit.SP)
        setTextColor(0xff2DA5EC.toInt())
        setBackgroundColor(Color.YELLOW)
        gravity = Gravity.CENTER
        background = Shaper.getShape(cornerRadius = 70f, borderColor = 0xff2DA5EC.toInt(), borderWidth = 6)
        val dim10 = Dimension.getSystemSize(context, 35f, SizeUnit.DP).toInt()
        val params = Dimension.getFrameLayoutParams(
            numericWidth = dim10,
            numericHeight = dim10,
            gravity = Gravity.RIGHT
        )
        params.setMargins(
            0,
            Dimension.getSystemSize(context, 12f, SizeUnit.DP).toInt(),
            Dimension.getSystemSize(context, 7f, SizeUnit.DP).toInt(),
            0
        )
        layoutParams = params
    }

    private val mainContainer = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = Dimension.getFrameLayoutParams(
            width = LayoutParamsType.FILL,
            height = LayoutParamsType.FILL
        )
    }

    private val leftProfileImage = CircleImageView(context).apply {
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cat_profile))
        val dim = Dimension.getSystemSize(context, 50f, SizeUnit.DP).toInt()
        val params = Dimension.getLLayoutParams(
            numericWidth = dim,
            numericHeight = dim
        )
        params.gravity = Gravity.LEFT
        params.setMargins(
            0,
            Dimension.getSystemSize(context, 15f, SizeUnit.DP).toInt(),
            0,
            Dimension.getSystemSize(context, 10f, SizeUnit.DP).toInt()
        )
        layoutParams = params
    }

    private val tvUserAccount = TextView(context).apply {
        text = "Muhammad Fatani"
        textSize = 16f
        setTextColor(Color.BLACK)
        setTypeface(null, Typeface.BOLD)
    }

    private val tvUsername = TextView(context).apply {
        text = "@DevFatani"
        textSize = 14f
        setTextColor(Color.GRAY)
    }


    private val followingContainer = LinearLayout(context).apply {
        val tvFollowing = TextView(context)
        tvFollowing.text = "Following"
        tvFollowing.setTextColor(Color.GRAY)
        tvFollowing.textSize = 16f
        tvFollowing.setPadding(Dimension.getSystemSize(context, 5f, SizeUnit.DP).toInt(), 0, 0, 0)

        val tvNum = TextView(context)
        tvNum.text = "99"
        tvNum.setTypeface(null, BOLD)
        tvNum.setTextColor(Color.BLACK)

        addView(tvFollowing)
        addView(tvNum)
        layoutParams = Dimension.getLLayoutParams(width = LayoutParamsType.WRAP, height = LayoutParamsType.WRAP)
    }

    private val followersContainer = LinearLayout(context).apply {
        val tvFollower = TextView(context)
        tvFollower.text = "Follower"
        tvFollower.setTextColor(Color.GRAY)
        tvFollower.textSize = 16f
        tvFollower.setPadding(Dimension.getSystemSize(context, 5f, SizeUnit.DP).toInt(), 0, 0, 0)

        val tvNum = TextView(context)
        tvNum.text = "99"
        tvNum.setTypeface(null, BOLD)
        tvNum.setTextColor(Color.BLACK)

        addView(tvFollower)
        addView(tvNum)
        setPadding(Dimension.getSystemSize(context, 10f, SizeUnit.DP).toInt(), 0, 0, 0)
        layoutParams = Dimension.getLLayoutParams(width = LayoutParamsType.WRAP, height = LayoutParamsType.WRAP)
    }

    private val containersFollow = LinearLayout(context).apply {
        gravity = Gravity.LEFT
        setPadding(0, Dimension.getSystemSize(context, 10f, SizeUnit.DP).toInt(), 0, 0)
    }

    private val myList = TextView(context).apply {
        text = "My List"
        setTextColor(Color.BLACK)
        textSize = Dimension.getSystemSize(context, 30f, SizeUnit.DP)
        gravity = Gravity.CENTER
        layoutParams = Dimension.getLLayoutParams(width = LayoutParamsType.FILL, height = LayoutParamsType.FILL)
    }

    init {

        setBackgroundColor(Color.WHITE)
        addView(mainContainer)
        addView(topRightIcon)

        mainContainer.addView(leftProfileImage)
        mainContainer.addView(tvUserAccount)
        mainContainer.addView(tvUsername)


        containersFollow.addView(followersContainer)
        containersFollow.addView(followingContainer)
        mainContainer.addView(containersFollow)
        mainContainer.addView(myList)

        val halfScreen = Dimension.getScreenSize(activity).first * 0.5
        val params = Dimension.getLLayoutParams(
            numericWidth = halfScreen.toInt(),
            height = LayoutParamsType.FILL
        )
        setPadding(
            Dimension.getSystemSize(context, 20f, SizeUnit.DP).toInt(),
            0,
            0,
            0
        )
        layoutParams = params
    }

    fun toggleView() {
        val offset = Dimension.getScreenSize(activity).first * if (isOpen) 0f else 0.5f
        val animationDuration = 400L
        val mainViesContainerAnimator =
            ObjectAnimator.ofFloat(
                container,
                "translationX",
                offset
            ).apply {
                duration = animationDuration
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {

                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {
                        if (isOpen) {
                            blackView.isClickable = false
                            blackView.animate().alpha(0f).start()
                        } else {
                            blackView.isClickable = true
                            blackView.animate().alpha(0.8f).start()
                        }
                    }

                })
            }

        val slideViewAnimator =
            ObjectAnimator.ofFloat(this, "translationX", offset)
                .apply {
                    duration = animationDuration
                }

        AnimatorSet().apply {
            playTogether(slideViewAnimator, mainViesContainerAnimator)
            start()
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    isOpen = !isOpen
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })
        }
    }

    fun hideSlideView() {
        isOpen = true
        toggleView()
    }

}