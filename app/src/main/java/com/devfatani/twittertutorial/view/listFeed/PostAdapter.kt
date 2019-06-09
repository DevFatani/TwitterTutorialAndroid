package com.devfatani.twittertutorial.view.listFeed

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.devfatani.twittertutorial.accessories.Dimension
import com.devfatani.twittertutorial.accessories.LayoutParamsType
import com.devfatani.twittertutorial.accessories.SizeUnit
import com.devfatani.twittertutorial.model.Post

class PostAdapter(context: Context, private val posts: ArrayList<Post>) :
    ArrayAdapter<Post>(context, 0, posts) {
    override fun getCount(): Int = posts.size


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
        PostCell(context, posts[position])
}