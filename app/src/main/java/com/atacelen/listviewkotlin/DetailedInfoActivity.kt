package com.atacelen.listviewkotlin

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detailed_info.*

class DetailedInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_info)

        val intent = intent
        val foodName = intent.getStringExtra("foodName")
        val foodCalories = intent.getIntExtra("foodCalories", 0)

        foodNameText.text = foodName
        foodCaloriesText.text = foodCalories.toString()
        /*
        val singleton = Singleton.Selected
        val selectedImage = singleton.selectedImage

        imageView.setImageBitmap(selectedImage)

         */

        val foodImagesID = intent.getIntExtra("foodImagesID", 0)
        val selectedImage = BitmapFactory.decodeResource(applicationContext.resources, foodImagesID)
        imageView.setImageBitmap(selectedImage)

    }

}