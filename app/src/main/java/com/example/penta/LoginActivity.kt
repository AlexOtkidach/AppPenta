package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextPhone: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonGuest: Button

    // Список допустимых номеров телефонов в формате Map
    private val validPhoneNumbers = mapOf(
        "9998034540" to "Алексей",
        "9887781439" to "Кристина",
        "9261263531" to "Виталий"
        // Номера и имена по необходимости
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextPhone = findViewById(R.id.editTextPhone)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonGuest = findViewById(R.id.buttonGuest)

        buttonLogin.setOnClickListener {
            val phoneNumber = editTextPhone.text.toString()
            val userName = validPhoneNumbers[phoneNumber]

            if (userName != null) {
                Toast.makeText(this, "Добро пожаловать, $userName!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "ПУ-ПУ-ПУ не получилось, попробуй войти как гость", Toast.LENGTH_LONG).show()
            }
        }

        buttonGuest.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
