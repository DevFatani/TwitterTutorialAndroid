package com.devfatani.twittertutorial.model

import org.json.JSONObject

class User(
    val userAccount: String,
    val username: String,
    val avatar: String
) {
    companion object {
        fun parse(args: JSONObject): User = User(
            args.getString("userAccount"),
            args.getString("username"),
            args.getString("avatar")
        )
    }
}