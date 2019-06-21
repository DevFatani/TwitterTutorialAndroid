package com.devfatani.twittertutorial

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View

import android.widget.FrameLayout
import android.widget.LinearLayout
import com.devfatani.twittertutorial.accessories.Dimension
import com.devfatani.twittertutorial.accessories.FetchMockData
import com.devfatani.twittertutorial.model.Post
import com.devfatani.twittertutorial.view.AppBarView
import com.devfatani.twittertutorial.view.listFeed.ListFeed
import com.devfatani.twittertutorial.view.slideView.SlideView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : Activity() {


    private val masterView: LinearLayout by lazy(LazyThreadSafetyMode.NONE) {
        LinearLayout(this).apply {
            layoutDirection = View.LAYOUT_DIRECTION_RTL
            orientation = LinearLayout.HORIZONTAL
        }
    }

    private val containerViewsAndBlack: FrameLayout by lazy(LazyThreadSafetyMode.NONE) {
        FrameLayout(this)
    }

    private val containerViews: LinearLayout by lazy(LazyThreadSafetyMode.NONE) {
        LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }
    }

    private val blackView: View by lazy(LazyThreadSafetyMode.NONE) {
        View(this).apply {
            setBackgroundColor(Color.BLACK)
            alpha = 0f
            layoutParams = Dimension.getViewParams(
                width =   Dimension.Type.FILL,
                height =   Dimension.Type.FILL
            )
            setOnClickListener { slideView.hideSlideView() }
        }
    }

    private val appBarView: AppBarView by lazy(LazyThreadSafetyMode.NONE) {
        AppBarView(this)
    }

    private val listFeed: ListFeed by lazy(LazyThreadSafetyMode.NONE) {
        ListFeed(this)
    }

    private val slideView: SlideView by lazy(LazyThreadSafetyMode.NONE) {
        SlideView(this, containerViewsAndBlack, blackView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        containerViewsAndBlack.addView(containerViews)
        containerViewsAndBlack.addView(blackView)
        masterView.addView(containerViewsAndBlack)
        masterView.addView(slideView)

        setContentView(
            masterView,
            Dimension.getLLayoutParams(width = Dimension.Type.FILL, height = Dimension.Type.FILL)
        )

        val postsArrayJSON = JSONArray(FetchMockData.loadJSONFromAssetBy("Posts", this))
        val posts = ArrayList<Post>()
        for (i in (0 until postsArrayJSON.length())) {
            posts.add(Post.parse(JSONObject(postsArrayJSON[i].toString())))
        }
        listFeed.setPosts(posts)
        containerViews.addView(appBarView)
        containerViews.addView(listFeed)


        appBarView.setLeftProfileImageAction {
            slideView.toggleView()

        }
    }

}