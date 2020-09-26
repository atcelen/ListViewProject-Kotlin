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

        // Called to render the UI of your activity. The design is determined by the xml file inflated to the activity.
        setContentView(R.layout.activity_main)

        //Initializing the Food Names array list (Array lists don't have a fixed length therefore they are better suited in this context)
        val foodNames = ArrayList<String>()
        foodNames.add("Quattro Formaggi")
        foodNames.add("Ravioli")
        foodNames.add("Paella")
        foodNames.add("Fondue")
        foodNames.add("Sushi")

        //Initializing the Food Calories array list
        val foodCalories = ArrayList<Int>()
        foodCalories.add(728)
        foodCalories.add(215)
        foodCalories.add(234)
        foodCalories.add(492)
        foodCalories.add(255)

        /*
            "BitmapFactory.decodeResource" method converts a resource into a Bitmap.
            Its parameters are the resources of the current Activity. (You could either use "MainActivity.this" or "getApplicationContext()"as the context)

            If you want to add an image to your project, you can add it in the file "res/drawable" (not "res/drawable-v24"!).

            Documentation:
            https://docs.microsoft.com/en-us/dotnet/api/android.graphics.bitmapfactory.decoderesource?view=xamarin-android-sdk-9
        */

        // Initializing the food Images array list

        /*
        val foodImages = ArrayList<Bitmap>()
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.quattro_formaggi))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ravioli))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.paella))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.fondue))
        foodImages.add(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.sushi))

         */

        //Carrying Images more efficiently (the less efficient method is commented out, but works as well)
        val quattroFormaggiID = R.drawable.quattro_formaggi
        val ravioliID = R.drawable.ravioli
        val paellaID = R.drawable.paella
        val fondueID = R.drawable.fondue
        val  sushiID = R.drawable.sushi

        //Initializing the food image IDs array list
        val foodImagesIDs = ArrayList<Int>()
        foodImagesIDs.add(quattroFormaggiID)
        foodImagesIDs.add(ravioliID)
        foodImagesIDs.add(paellaID)
        foodImagesIDs.add(fondueID)
        foodImagesIDs.add(sushiID)

        /*
            We define an array adapter, which converts the array lists into views that are later added to the listView.
            The method takes the context ,the resource and an array of objects as parameters.
            In this example, we can directly use the resource provided to us by Android Studio. However, we will be creating our own layout in the customView project.
            You can also experiment with other layout types under "android.R.layout"
         */
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, foodNames)
        listView.adapter = adapter

        // This method is called when an item on the listView is being clicked on
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            /*
            Intents are mainly used to jump between activities and classes ( We will also see other examples).
            As parameters, the current context and the class that will be switched to, is given.
             */
            val intent = Intent(this@MainActivity, DetailedInfoActivity::class.java)

            //"putExtra" method adds information to our intent, which will then be carried to the other activity
            intent.putExtra("foodName", foodNames.get(i))
            intent.putExtra("foodCalories", foodCalories.get(i))

            /*
            val singleton = Singleton.Selected
            singleton.selectedImage = foodImages[i]

             */

            intent.putExtra("foodImagesID",foodImagesIDs.get(i))

            //Used to start the intent
            startActivity(intent)
        }
    }
}