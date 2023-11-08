package com.ozcanbayram.catchthejerry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ozcanbayram.catchthejerry.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable {}
    var handler = Handler(Looper.getMainLooper())

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

        //CountDownTimer
        object : CountDownTimer(10900,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time: ${p0/1000}"
            }

            override fun onFinish() {
                binding.timeText.text = "Time is up!"
                handler.removeCallbacks(runnable)

                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }

                //alert dialog
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Time is up!")
                alert.setMessage("Are you want to play again?")
                alert.setPositiveButton("YES",DialogInterface.OnClickListener { dialogInterface, i ->
                    //restart
                    val intentFromMain = intent
                    finish()
                    startActivity(intentFromMain)
                })
                alert.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->
                    //exit
                    System.exit(0)
                })
                alert.show()

            }

        }.start()

    }

    fun hideImages(){

        runnable = object : Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random
                val randomImage = random.nextInt(9)
                imageArray[randomImage].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }
        }
        handler.post(runnable)
    }

    fun increaseScore(view : View){
        score = score + 1
        binding.scoreText.text = "Score: ${score}"
    }

}