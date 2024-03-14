package com.example.penta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// InfoActivity.kt
class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val buttonInfo1 = findViewById<Button>(R.id.buttonInfo1)
        val buttonInfo2 = findViewById<Button>(R.id.buttonInfo2)
        val buttonInfo3 = findViewById<Button>(R.id.buttonInfo3)
        val buttonInfo4 = findViewById<Button>(R.id.buttonInfo4)
        val buttonInfo5 = findViewById<Button>(R.id.buttonInfo5)

        buttonInfo1.setOnClickListener {
            startActivityForProduct(1)
        }

        buttonInfo2.setOnClickListener {
            startActivityForProduct(2)
        }

        buttonInfo3.setOnClickListener {
            startActivityForProduct(3)
        }

        buttonInfo4.setOnClickListener {
            startActivityForProduct(4)
        }

        buttonInfo5.setOnClickListener {
            startActivityForProduct(5)
        }
    }

    private fun startActivityForProduct(productNumber: Int) {
        val intent = when (productNumber) {
            1 -> Intent(this, ProductInfo1Activity::class.java)
            2 -> Intent(this, ProductInfo2Activity::class.java)
            3 -> Intent(this, ProductInfo3Activity::class.java)
            4 -> Intent(this, ProductInfo4Activity::class.java)
            5 -> Intent(this, ProductInfo5Activity::class.java)
            else -> throw IllegalArgumentException("Invalid product number: $productNumber")
        }
        intent.putExtra("product_number", productNumber)
        startActivity(intent)
    }
}

// ProductInfoActivity.kt
class ProductInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info_1)

        // Получение номера продукта из интента
        intent.getIntExtra("product_number", 0)

        // Здесь можно произвести настройку отображения информации о продукте в зависимости от его номера
    }
}
