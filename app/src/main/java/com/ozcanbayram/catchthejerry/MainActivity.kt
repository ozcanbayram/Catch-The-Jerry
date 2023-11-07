package com.ozcanbayram.catchthejerry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.ozcanbayram.catchthejerry.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var score = 0
    var imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Image Array
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)

        hideImages()

    }

    fun hideImages(){

        for(image in imageArray){
            image.visibility = View.INVISIBLE
        }
        val random = Random
        val randomImage = random.nextInt(9)
        imageArray[randomImage].visibility = View.VISIBLE

    }

    fun increaseScore(view : View){
        score = score + 1
        binding.scoreText.text = "Score: ${score}"
    }

}