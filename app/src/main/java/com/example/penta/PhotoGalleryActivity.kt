package com.example.penta

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PhotoGalleryActivity : AppCompatActivity() {

    private lateinit var imageViewPhoto: ImageView
    private lateinit var btnPrevious: ImageButton
    private lateinit var btnNext: ImageButton

    private val imageResources = arrayOf(
        R.drawable.ppf3,
        R.drawable.moto_gt,
        R.drawable.ppf4,
        R.drawable.ppf2,
        R.drawable.ppf7,
        R.drawable.ppf9,
        R.drawable.ppf10,
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info_6)

        imageViewPhoto = findViewById(R.id.imageViewPhoto)
        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)

        // Устанавливаем начальное изображение
        updateImage()

        btnPrevious.setOnClickListener {
            currentIndex = (currentIndex - 1 + imageResources.size) % imageResources.size
            updateImage()
        }

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % imageResources.size
            updateImage()
        }
    }

    private fun updateImage() {
        imageViewPhoto.setImageResource(imageResources[currentIndex])
    }
}