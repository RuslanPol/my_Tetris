package storage

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Build.VERSION


class AppPreferences(ctx: Context) {
    var data: SharedPreferences = ctx.getSharedPreferences("game", Context.MODE_PRIVATE)

    fun saveHighScore(highScore: Int) {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            data.edit().putInt("HIGH_SCORE", highScore).apply()
        }
    }

    fun getHighScore(): Int {
        return data.getInt("HIGH_SCORE", 0)
    }

    fun clearHighScore() {

        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
}