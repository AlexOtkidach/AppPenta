package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class OrderActivity : AppCompatActivity() {

    private lateinit var etCarModel: EditText
    private lateinit var spinnerCompanies: Spinner
    private lateinit var spinnerWorks: Spinner
    private lateinit var btnConfirmOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        spinnerCompanies = findViewById(R.id.spinnerCompanies)
        spinnerWorks = findViewById(R.id.spinnerWorks)
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder)

        etCarModel = findViewById(R.id.etCarModel)

        val companies = listOf("Company A", "Company B", "Company C", "Company D")
        val works = listOf("Work A", "Work B", "Work C", "Work D")

        spinnerCompanies.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, companies)
        spinnerWorks.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, works)

        btnConfirmOrder.setOnClickListener {
            val customer = spinnerCompanies.selectedItem.toString()
            val work = spinnerWorks.selectedItem.toString()
            // Получение даты работы
            //val date = datePickerOrder.date
            val carModel = etCarModel.text.toString() // значение из EditText

            val orderText = "Заказчик: $customer\nРабота: $work\nДата: Текущая дата\nМарка автомобиля: $carModel"
            sendEmail(orderText)

            clearFields()


        }
    }

    private fun sendEmail(orderText: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@example.com"))
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


