package com.imastudio.customerapp.helper


import android.content.Context
import android.content.SharedPreferences


class SessionManager
    (internal var c: Context) {
    internal var pref: SharedPreferences
    internal var editor: SharedPreferences.Editor
    internal var PRIVATE_MODE = 0
    //0 agar cuma bsa dibaca hp itu sendiri
    internal var PREF_NAME = "CRUDMahaiswaPref"
    //cek login
    val isLogin: Boolean
        get() = pref.getBoolean(KEY_LOGIN, false)

    var username: String
        get() = pref.getString("username", "").toString()
        set(username) {
            editor.putString("username", username)
            editor.commit()
        }

    var iduser: String
        get() = pref.getString(KEY_IDUSER, "").toString()
        set(iduser) {
            editor.putString(KEY_IDUSER, iduser)
            editor.commit()
        }

    init {
        pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    //membuat session login
    fun createLoginSession(token :String?) {
        editor.putString(KEY_TOKEN,token)
        editor.putBoolean(KEY_LOGIN, true)
        editor.commit()
        //commit digunakan untuk menyimpan perubahan
    }
    fun  getToken() =pref.getString(KEY_TOKEN,"").toString()

    //logout user
    fun logout() {
        editor.clear()
        editor.commit()

    }

    companion object {
        private val KEY_LOGIN = "isLogin"
        private val KEY_TOKEN = "token"
        private val KEY_IDUSER = "iduser"
    }


}