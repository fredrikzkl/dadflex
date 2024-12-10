package com.example.dadflex.preferences

import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
        // Convert to JSON with kotlin serialization
        val highscoreJson = Json.encodeToString(highscore)

        val editor = getPreferences(context).edit()

        editor.putString(KEY_HIGHSCORE, highscoreJson)
        editor.apply()
    }

    fun getHighscore(context: Context): Highscore {
        val json = getPreferences(context).getString(KEY_HIGHSCORE, null) ?: return Highscore()
        // Decode with kotlin serialization

        return try {
            Json.decodeFromString(json)
        } catch (e: Exception) {
            // Old java.util.Date format e.g 'Dec 10, 2024 4:42:44 PM' can't be parsed :(
            Highscore()
        }
    }
}