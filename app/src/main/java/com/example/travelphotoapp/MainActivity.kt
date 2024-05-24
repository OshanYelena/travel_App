package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelphotoapp.ui.theme.TravelPhotoAppTheme

class MainActivity : ComponentActivity() {

    var currentImage = 0
  lateinit  var image: ImageView
      var places = arrayOf("London", "USA", "Canada", "Australia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tVName)

        next.setOnClickListener{

            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage+1)%5

            var idImageToShowString =  "pic$currentImage"
            var idImageToShow = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShow)
            image.alpha = 1f
            placeName.text = places[currentImage]

        }

        prev.setOnClickListener{

            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage-1)%5

            var idImageToShowString =  "pic$currentImage"
            var idImageToShow = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShow)
            image.alpha = 1f
            placeName.text = places[currentImage]
        }
    }
}

