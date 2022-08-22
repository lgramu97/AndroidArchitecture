package com.anncode.offersandcoupons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagePhoto: ImageView = findViewById(R.id.imagePhoto)
        val imagePhoto2: ImageView = findViewById(R.id.imagePhoto2)
        val btnGetImage: Button = findViewById(R.id.btnGetImage)

        //var model: MainActivityViewModel = MainActivityViewModel()

        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        var urlImage: MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer{
            print("Se ejecuta si la url sufre un cambio")
            Picasso.get().load(it).into(imagePhoto)
            Picasso.get().load(it).into(imagePhoto2)

        })

        btnGetImage.setOnClickListener{
            model.randomNumbersUrl()
        }




    }
}