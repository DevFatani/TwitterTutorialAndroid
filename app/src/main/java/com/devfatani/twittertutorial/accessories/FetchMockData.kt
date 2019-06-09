package com.devfatani.twittertutorial.accessories

import android.content.Context
import java.io.IOException

object FetchMockData {
    fun loadJSONFromAssetBy(fileName: String, context: Context): String? {
        val json: String
        try {
            val `is` = context.assets.open("data/$fileName.json")

            val size = `is`.available()

            val buffer = ByteArray(size)

            `is`.read(buffer)

            `is`.close()

            json = String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }


}