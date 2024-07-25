package com.example.penta

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var checkBoxPersonalData: CheckBox
    private lateinit var checkBoxPushNotifications: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Инициализация галочек
        checkBoxPersonalData = findViewById(R.id.checkBoxPersonalData)
        checkBoxPushNotifications = findViewById(R.id.checkBoxPushNotifications)

        // Установка слушателей для изменения состояния галочек
        checkBoxPersonalData.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Действия при согласии на обработку персональных данных
                Toast.makeText(this, "Вы дали согласие на обработку персональных данных", Toast.LENGTH_SHORT).show()
            } else {
                // Действия при отказе от обработки персональных данных
                Toast.makeText(this, "Вы отказались от обработки персональных данных", Toast.LENGTH_SHORT).show()
            }
        }

        checkBoxPushNotifications.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Действия при разрешении пуш-уведомлений
                Toast.makeText(this, "Вы разрешили пуш-уведомления", Toast.LENGTH_SHORT).show()
            } else {
                // Действия при отказе от пуш-уведомлений
                Toast.makeText(this, "Вы отказались от пуш-уведомлений", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Функция для обработки нажатия на кнопку "Поделиться приложением"
    fun shareApp(view: View) {
        val appMarketLink = "https://apps.rustore.ru/app/com.example.penta"

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Поделиться приложением")
        intent.putExtra(Intent.EXTRA_TEXT, "Привет! Я использую приложение Penta. Узнайте больше и загрузите его здесь: $appMarketLink")
        startActivity(Intent.createChooser(intent, "Поделиться через"))
    }

    // Функция для обработки нажатия на кнопку "Обратная связь и поддержка"
    fun callSupport(view: View) {
        val phoneNumber = "+79939134540" // Укажите здесь номер поддержки
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }
}
