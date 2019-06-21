package com.devfatani.twittertutorial.view.listFeed

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.ListView
import com.devfatani.twittertutorial.model.Post
import com.devfatani.twittertutorial.accessories.Dimension

class ListFeed(context: Context) : ListView(context) {

    private val posts = ArrayList<Post>()

    private val postAdapter = PostAdapter(context, posts)

    init {
        setBackgroundColor(Color.DKGRAY)
        adapter = postAdapter
        divider = null
        layoutParams = Dimension.getFrameLayoutParams(
            width = Dimension.Type.FILL,
            height = Dimension.Type.FILL
        )
    }

    fun setPosts(newPosts: ArrayList<Post>) {
        posts.clear()
        posts.addAll(newPosts)
        postAdapter.notifyDataSetChanged()
    }
}