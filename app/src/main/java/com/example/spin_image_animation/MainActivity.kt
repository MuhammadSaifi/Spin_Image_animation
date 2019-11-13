package com.example.spin_image_animation

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView

import java.util.Random

// this is done by using animation codes.
// here we will use rotate animation.
// random() will be randomly move .


class MainActivity : AppCompatActivity() {

    private var battery: ImageView? = null
    private val random = Random()

    //lastDir is our last direction.
    private var lastDir: Int = 0
    private var spinning: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        battery = findViewById(R.id.battery)
    }

    fun spinbattery(v: View) {
        if (!spinning) {

            // bound mean it will generate number from 0 to 1800
            val newDir = random.nextInt(1800)
            // get widht of image and divide by 2 and rotate according to it.
            // same happend with pivot y.
            val pivotx = (battery!!.width / 2).toFloat()
            val pivoty = (battery!!.height / 2).toFloat()
            val rotate = RotateAnimation(lastDir.toFloat(), newDir.toFloat(), pivotx, pivoty)
            rotate.duration = 2500
            // fill after will generate our starting animation position when we click on it.
            rotate.fillAfter = true
            rotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {

                    spinning = true
                }

                override fun onAnimationEnd(animation: Animation) {

                    spinning = false
                }

                override fun onAnimationRepeat(animation: Animation) {


                }
            })

            lastDir = newDir
            battery!!.startAnimation(rotate)
        }
    }
}
