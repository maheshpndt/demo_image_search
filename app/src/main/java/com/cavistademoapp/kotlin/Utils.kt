package com.cavistademoapp.kotlin

import android.content.Context
import android.preference.PreferenceManager


fun setValue(key: String?, value: String?, context: Context?) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    val editor = prefs.edit()
    editor.putString(key, value)
    editor.commit()
}

fun getValue(key: String?, context: Context?): String? {
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    return preferences.getString(key, null)
}