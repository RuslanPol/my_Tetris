package com.example.mytetris


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import storage.AppPreferences

class MainActivity : AppCompatActivity() {
    var tvHighScore:TextView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.btn_new_game);
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score);
        val btnExit = findViewById<Button>(R.id.btn_exit);
        tvHighScore=findViewById(R.id.tv_high_score);
        btnNewGame.setOnClickListener(this::onBtnNewGameClick);
        btnResetScore.setOnClickListener(this::onBtnResetClick);
        btnExit.setOnClickListener(this::onBtnExitClick);

        updateHighScore()
    }

    private fun onBtnNewGameClick(view:View){
        val intent= Intent (this,GameActivity::class.java);  //intent-намерение
        startActivity(intent);
//        try {
//            val intent = Intent(this, GameActivity::class.java)
//            startActivity(intent)
//        } catch (e: Exception) {
//            Log.e("Error", e.message.toString())
//        }
    }
    //@SuppressLint("SetTextI18n")
    private  fun onBtnResetClick(view:View){
        val preferences= AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view,"Score successfully reset",Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text="HighScore:${preferences.getHighScore()}"
    }
    private  fun onBtnExitClick(view:View){
        System.exit(0);
    }
    private fun updateHighScore() {
        val preferences = AppPreferences(this)
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
    }


}