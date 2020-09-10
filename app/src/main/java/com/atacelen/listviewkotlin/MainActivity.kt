package com.atacelen.listviewkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodNames = ArrayList<String>()
        foodNames.add("Quattro Formaggi")
        foodNames.add("Ravioli")
        foodNames.add("Paella")
        foodNames.add("Fondue")
        foodNames.add("Sushi")

        val foodCalories = ArrayList<Int>()
        foodCalories.add(728)
        foodCalories.add(215)
        foodCalories.add(234)
        foodCalories.add(492)
        foodCalories.add(255)

        /*
        val foodImages = ArrayList<Bitmap>()
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.quattro_formaggi))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ravioli))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.paella))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.fondue))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.sushi))

         */

        //Carrying Images more efficiently
        val quattroFormaggiID = R.drawable.quattro_formaggi
        val ravioliID = R.drawable.ravioli
        val paellaID = R.drawable.paella
        val fondueID = R.drawable.fondue
        val  sushiID = R.drawable.sushi

        val foodImagesIDs = ArrayList<Int>()
        foodImagesIDs.add(quattroFormaggiID)
        foodImagesIDs.add(ravioliID)
        foodImagesIDs.add(paellaID)
        foodImagesIDs.add(fondueID)
        foodImagesIDs.add(sushiID)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, foodNames)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedInfoActivity::class.java)
            intent.putExtra("foodName", foodNames.get(i))
            intent.putExtra("foodCalories", foodCalories.get(i))

            /*
            val singleton = Singleton.Selected
            singleton.selectedImage = foodImages[i]

             */

            intent.putExtra("foodImagesID",foodImagesIDs.get(i))

            startActivity(intent)
        }
    }
}