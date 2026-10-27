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

        // شروعاتی کوائنز دکھانا
        tvCoins.text = "$userCoins Coins"

        // 1. گرینی گیم ٹاسک سسٹم
        btnTaskGranny.setOnClickListener {
            if (!taskCompleted) {
                try {
                    // پلے سٹور پر گرینی گیم کا لنک اوپن کرنا
                    val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.dvloper.granny"))
                    startActivity(playStoreIntent)
                    
                    // 50 کوائنز ایڈ کرنا
                    userCoins += 50
                    taskCompleted = true
                    tvCoins.text = "$userCoins Coins"
                    
                    Toast.makeText(this, "مبارک ہو! آپ کو گرینی ٹاسک مکمل کرنے پر 50 کوائنز مل گئے ہیں", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "لنک اوپن کرنے میں کوئی مسئلہ ہے", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "آپ یہ ٹاسک پہلے ہی مکمل کر چکے ہیں!", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. پیمنٹ ود ڈرا سسٹم
        btnWithdraw.setOnClickListener {
            if (userCoins >= 500) {
                Toast.makeText(this, "آپ کی ود ڈرا کی درخواست کامیابی سے جمع ہو گئی ہے!", Toast.LENGTH_LONG).show()
                // یہاں آپ چاہیں تو ود ڈرا کے بعد کوائنز مائنس یا ری سیٹ بھی کر سکتے ہیں
            } else {
                Toast.makeText(this, "ود ڈرا کے لیے کم از کم 500 کوائنز کا ہونا ضروری ہے! (موجودہ: $userCoins)", Toast.LENGTH_LONG).show()
            }
        }
    }
}
