package com.example.penta

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.sql.Date

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val spinnerCompanies = findViewById<Spinner>(R.id.spinnerCompanies)
        val spinnerWorks = findViewById<Spinner>(R.id.spinnerWorks)
        val btnConfirmOrder = findViewById<Button>(R.id.btnConfirmOrder)

        // Заполнение списка компаний для выбора заказчика
        val companies = listOf("Company A", "Company B", "Company C", "Company D")
        val companyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, companies)
        spinnerCompanies.adapter = companyAdapter

        // Заполнение списка работ
        val works = listOf("Work A", "Work B", "Work C", "Work D")
        val workAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, works)
        spinnerWorks.adapter = workAdapter

        // Обработчик нажатия на кнопку подтверждения заказа
        btnConfirmOrder.setOnClickListener {
            // Получение данных из полей
            val customer = spinnerCompanies.selectedItem.toString()
            val work = spinnerWorks.selectedItem.toString()
            val date = datePickerOrder.date
            val carModel = etCarModel.text.toString()

            // Формирование текста заказа
            val orderText = "Заказчик: $customer\nРабота: $work\nДата: ${Date(date)}\nМарка автомобиля: $carModel"

            // Отправка данных на почту (здесь необходимо добавить код отправки почты)
            sendEmail(orderText)

            // Очистка полей после отправки заказа
            clearFields()
        }
    }

    private fun sendEmail(orderText: String) {
        // Здесь нужно добавить логику отправки электронной почты
        // Например, использовать Intent для отправки электронной почты
        // Это будет зависеть от вашей реализации отправки почты
        // Ниже пример использования Intent для отправки почты (необходимо настроить почтовый клиент на устройстве)
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@example.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Новый заказ")
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderText)
        startActivity(Intent.createChooser(emailIntent, "Отправить заказ"))
    }

    private fun clearFields() {
        // Очистка полей формы заказа
        spinnerCompanies.setSelection(0)
        spinnerWorks.setSelection(0)
        etCarModel.setText("")
    }
}


