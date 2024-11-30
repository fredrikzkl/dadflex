package com.example.dadflex.preferences

import com.google.gson.Gson

import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {
    private const val PREFS_NAME = "dadflex_prefs"
    private const val KEY_NAME = "key_name"
    private const val KEY_HIGHSCORE = "key_heyscore"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveName(context: Context, name: String) {
        val editor = getPreferences(context).edit()
        editor.putString(KEY_NAME, name)
        editor.apply()
    }

    fun getName(context: Context): String? {
        return getPreferences(context).getString(KEY_NAME, null)
    }

    fun saveHighscore(context: Context, highscore: Highscore) {
        val gson = Gson()
        val highscoreJson = gson.toJson(highscore)
        val editor = getPreferences(context).edit()

        editor.putString(KEY_HIGHSCORE, highscoreJson)
        editor.apply()
    }

    fun getHighscore(context: Context): Highscore {
        val gson = Gson()
        val json = getPreferences(context).getString(KEY_HIGHSCORE, null) ?: return Highscore()
        return gson.fromJson(json, Highscore::class.java)
    }
}