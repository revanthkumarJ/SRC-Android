package com.example.src_android.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

class DecodeBase64ToBitmap  {
        fun decodeBase64ToBitmap(base64String: String): Bitmap? {
            return try {
                val imageData = Base64.decode(base64String, Base64.DEFAULT)
                BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
}