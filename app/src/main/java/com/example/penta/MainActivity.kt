package com.example.penta

import android.content.Intent
import android.net.Uri
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

        // Обработчик нажатия на кнопку Чат (WhatsApp)
        findViewById<View>(R.id.btnChat).setOnClickListener {
            // Вместо "номер_телефона" укажите номер телефона контакта в формате, принятом WhatsApp (например, "+7 123 456-78-90")
            val phoneNumber = "+7 993 913-45-30"
            val url = "https://wa.me/$phoneNumber"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Обработчик нажатия на кнопку Настройки
        findViewById<View>(R.id.btnSettings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}