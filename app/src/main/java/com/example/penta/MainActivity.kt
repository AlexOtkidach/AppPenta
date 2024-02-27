package com.example.penta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Обработчик нажатия на кнопку Заказ
        findViewById<View>(R.id.btnOrder).setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        // Обработчик нажатия на кнопку Инфо
        findViewById<View>(R.id.btnInfo).setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        // Обработчик нажатия на кнопку Чат
        findViewById<View>(R.id.btnChat).setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}