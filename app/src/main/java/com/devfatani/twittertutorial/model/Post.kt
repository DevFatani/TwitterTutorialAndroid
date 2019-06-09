package com.devfatani.twittertutorial.model

import org.json.JSONObject

class Post(
    val body: String,
    var numOfReply: Int,
    var numOfReTweet: Int,
    var numOfFavorite: Int,
    val time: String,
    val user: User,
    var isCurrentUserReply: Boolean = false,
    var isCurrentUserReTweet: Boolean = false,
    var isCurrentUserFavorite: Boolean = false
) {
    companion object {
        fun parse(args: JSONObject): Post = Post(
            args.getString("body"),
            args.getInt("numOfReply"),
            args.getInt("numOfReTweet"),
            args.getInt("numOfFavorite"),
            args.getString("time"),
            User.parse(args.getJSONObject("user"))
        )
    }
}