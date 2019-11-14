package com.imastudio.mvvmapp.helper

import android.os.Environment

class Helper {
    companion object {
        val BASE_URL = "http://192.168.60.136/wisata/"
        val BASE_WISATAURL = "https://api.myjson.com/bins/xjo4d/"
        const val DATAWISATA = "data"
        //cek sdcard tersedia atau tidak
        fun checkSdCard(): Boolean {
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED
                )
            ) {
                return true
            }
            return false
        }
    }
}