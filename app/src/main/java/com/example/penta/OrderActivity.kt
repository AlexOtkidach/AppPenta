package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class OrderActivity : AppCompatActivity() {

    private lateinit var etCarModel: EditText
    private lateinit var spinnerCompanies: Spinner
    private lateinit var spinnerWorks: Spinner
    private lateinit var etDate: EditText // EditText для ввода даты
    private lateinit var btnConfirmOrder: Button

    private val companies = listOf("Автоцентр на Таганке", "Major Сокольники", "Major Новая Рига", "Major 47км", "Major Магистральная")
    private val works = listOf("Полировка Новый", "Полировка Б/У", "Оклейка Полная", "Оклейка Передняя часть")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        btnConfirmOrder = findViewById(R.id.btnConfirmOrder)
        etCarModel = findViewById(R.id.etCarModel)
        spinnerCompanies = findViewById(R.id.spinnerCompanies)
        spinnerWorks = findViewById(R.id.spinnerWorks)
        etDate = findViewById(R.id.etDate) // Инициализация EditText для ввода даты

        // Установка адаптеров для выпадающих списков
        spinnerCompanies.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, companies)
        spinnerWorks.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, works)

        // Добавляем слушатель текста для EditText с датой
        etDate.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Ничего не делаем
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ничего не делаем
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Если введено 2 или 5 символов, добавляем точку после второго символа
                if (s?.length == 2 || s?.length == 5) {
                    etDate.append(".")
                }
            }
        })

        btnConfirmOrder.setOnClickListener {
            val carModel = etCarModel.text.toString()
            val date = etDate.text.toString() // Получение введенной даты
            val company = spinnerCompanies.selectedItem.toString() // Получение выбранной компании из спиннера

            val orderText = "Марка автомобиля: $carModel\nКомпания: $company\nДата: $date"
            sendEmail(orderText)

            clearFields()
        }
    }

    private fun sendEmail(orderText: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("order@pentaco.ru"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Новый заказ")
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderText)
        startActivity(Intent.createChooser(emailIntent, "Отправить заказ"))
    }

    private fun clearFields() {
        spinnerCompanies.setSelection(0)
        spinnerWorks.setSelection(0)
        etDate.setText("") // Очистка поля ввода даты
        etCarModel.setText("")
    }
}

