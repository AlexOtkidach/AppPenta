package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar


class OrderActivity : AppCompatActivity() {

    private lateinit var etCarModel: EditText
    private lateinit var spinnerCompanies: Spinner
    private lateinit var spinnerWorks: Spinner
    private lateinit var btnConfirmOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Показываем кнопку "назад" на тулбаре
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        btnConfirmOrder = findViewById(R.id.btnConfirmOrder)



        val companies = listOf("Major Сокольники", "Major Новая Рига", "Major 47км", "Major Магистральная")
        val works = listOf("Полировка Новый", "Полировка Б/У", "Оклейка Полная", "Оклейка Передняя часть")

        spinnerCompanies.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, companies)
        spinnerWorks.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, works)

        btnConfirmOrder.setOnClickListener {
            val customer = spinnerCompanies.selectedItem.toString()
            val work = spinnerWorks.selectedItem.toString()
            // Получение даты работы
            val carModel = etCarModel.text.toString() // значение из EditText

            val orderText = "Заказчик: $customer\nРабота: $work\nДата: Текущая дата\nМарка автомобиля: $carModel"
            sendEmail(orderText)

            clearFields()
        }
    }

    private fun sendEmail(orderText: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("penta.co@yandex.ru")) // Здесь указываем адрес получателя
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Новый заказ")
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderText)
        startActivity(Intent.createChooser(emailIntent, "Отправить заказ"))
    }

    private fun clearFields() {
        spinnerCompanies.setSelection(0)
        spinnerWorks.setSelection(0)
        // Очистка поля ввода марки автомобиля
        etCarModel.setText("")
    }
}


