package net.developia.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThreeColorActivity : AppCompatActivity() {

    lateinit var redButton: Button
    lateinit var greenButton: Button
    lateinit var blueButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_color)
        settingButtons()
        redButton.performClick()
    }

    fun settingButtons() {
        redButton = findViewById<Button>(R.id.button_red_fragment)
        greenButton = findViewById<Button>(R.id.button_green_fragment)
        blueButton = findViewById<Button>(R.id.button_blue_fragment)

        redButton.setOnClickListener {
            updateButtonState(redButton)
            val fragmentTransaction =
                supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFrame, RedFragment())
            fragmentTransaction.commit()
        }

        greenButton.setOnClickListener {
            updateButtonState(greenButton)
            val fragmentTransaction =
                supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFrame, GreenFragment())
            fragmentTransaction.commit()
        }

        blueButton.setOnClickListener {
            updateButtonState(blueButton)
            val fragmentTransaction =
                supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFrame, BlueFragment())
            fragmentTransaction.commit()
        }


    }

    private fun updateButtonState(activeButton: Button) {
        redButton.isEnabled = true
        greenButton.isEnabled = true
        blueButton.isEnabled = true

        activeButton.isEnabled = false

    }


}