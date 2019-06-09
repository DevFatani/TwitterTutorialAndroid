package com.devfatani.twittertutorial

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import com.devfatani.twittertutorial.accessories.Dimension
import com.devfatani.twittertutorial.accessories.FetchMockData
import com.devfatani.twittertutorial.accessories.LayoutParamsType
import com.devfatani.twittertutorial.model.Post
import com.devfatani.twittertutorial.model.User
import com.devfatani.twittertutorial.view.AppBarView
import com.devfatani.twittertutorial.view.listFeed.ListFeed
import com.devfatani.twittertutorial.view.listFeed.PostCell
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = LinearLayout(this)
        mainLayout.setBackgroundColor(0xff7171cc.toInt())
        mainLayout.orientation = LinearLayout.VERTICAL
        mainLayout.layoutParams = Dimension.getLLayoutParams(
            width = LayoutParamsType.FILL,
            height = LayoutParamsType.FILL
        )
        val appBarView = AppBarView(this)
        val listFeed = ListFeed(this)

//        mainLayout.addView(listFeed)
        setContentView(mainLayout)

        val postsArrayJSON = JSONArray(FetchMockData.loadJSONFromAssetBy("Posts", this))
        val posts = ArrayList<Post>()
        for (i in (0 until postsArrayJSON.length())) {
            posts.add(Post.parse(JSONObject(postsArrayJSON[i].toString())))
        }
        listFeed.setPosts(posts)
        mainLayout.addView(appBarView)
//        mainLayout.addView(PostCell(this, posts[0]))
        mainLayout.addView(listFeed)
        appBarView.setLeftProfileImageAction {
            mainLayout
                .animate()
                .translationX(500f)
                .setDuration(500)
                .setInterpolator(object : DecelerateInterpolator() {

                })
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {

                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {

                    }

                }).start()
        }
    }
}
