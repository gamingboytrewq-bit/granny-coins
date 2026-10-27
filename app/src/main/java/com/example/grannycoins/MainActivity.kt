package com.example.grannycoins

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var userCoins = 0
    private var taskCompleted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCoins: TextView = findViewById(R.id.tvCoins)
        val btnTaskGranny: Button = findViewById(R.id.btnTaskGranny)
        val btnWithdraw: Button = findViewById(R.id.btnWithdraw)

        tvCoins.text = "Coins: $userCoins"

        btnTaskGranny.setOnClickListener {
            if (!taskCompleted) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.dvloper.granny"))
                    startActivity(intent)
                    
                    userCoins += 50
                    taskCompleted = true
                    tvCoins.text = "Coins: $userCoins"
                    Toast.makeText(this, "مبارک ہو! آپ کو 50 کوائنز مل گئے ہیں", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "لنک اوپن کرنے میں مسئلہ ہے", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "آپ یہ ٹاسک پہلے ہی مکمل کر چکے ہیں!", Toast.LENGTH_SHORT).show()
            }
        }

        btnWithdraw.setOnClickListener {
            if (userCoins >= 500) {
                Toast.makeText(this, "پیمنٹ ود ڈرا کی درخواست جمع ہو گئی ہے!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "کم از کم 500 کوائنز ہونے ضروری ہیں!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
