package com.example.dadflex.preferences

import java.util.Date

data class HighscoreEntry(
    val name : String,
    val reactionTime : Long,
    val date : Date
)

class Highscore {
    private val highscoreList = mutableListOf<HighscoreEntry>()

    fun checkAndAddHighscore(entry: HighscoreEntry): Boolean {
        if (highscoreList.size < 5) {
            addHighscoreEntry(entry)
            return true;
        }

        val lastEntry = highscoreList.last()
        if (entry.reactionTime < lastEntry.reactionTime) {
            highscoreList.removeAt(4)
            addHighscoreEntry(entry)
            highscoreList.sortBy { it.reactionTime }
            return true;
        }

        return false;
    }

    fun addHighscoreEntry(entry: HighscoreEntry) {
        highscoreList.add(entry)
    }

    fun getHighscoreList(): List<HighscoreEntry> {
        return highscoreList
    }
}