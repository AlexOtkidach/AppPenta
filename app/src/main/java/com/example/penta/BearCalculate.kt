package com.example.penta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class BearCalculate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info_7)

        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etSalary = findViewById<EditText>(R.id.etSalary)
        val etMaterialCost = findViewById<EditText>(R.id.etMaterialCost)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvProfit = findViewById<TextView>(R.id.tvProfit)
        val tvMarginPercentage = findViewById<TextView>(R.id.tvMarginPercentage)

        btnCalculate.setOnClickListener {
            val price = etPrice.text.toString().toDoubleOrNull() ?: 0.0
            val salary = etSalary.text.toString().toDoubleOrNull() ?: 0.0
            val materialCost = etMaterialCost.text.toString().toDoubleOrNull() ?: 0.0

            val tax = price * 0.2
            val officeCost = price * 0.03
            val profit = price - salary - materialCost - tax - officeCost
            val marginPercentage = (profit / price) * 100

            tvProfit.text = "Прибыль: %.2f".format(profit)
            tvMarginPercentage.text = "Маржинальность: %.2f%%".format(marginPercentage)

            tvProfit.visibility = TextView.VISIBLE
            tvMarginPercentage.visibility = TextView.VISIBLE
        }
    }
}