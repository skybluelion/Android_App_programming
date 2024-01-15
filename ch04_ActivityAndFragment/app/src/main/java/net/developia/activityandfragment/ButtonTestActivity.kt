package net.developia.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class ButtonTestActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button1:Button
    lateinit var button2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_test)

        button1 = findViewById(R.id.button1)
//        button1.setOnClickListener {
//            Toast.makeText(applicationContext, "button 1이 클릭됨", Toast.LENGTH_SHORT).show()
//        }
        button2 = findViewById(R.id.button2)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("buttonclick", "Clicked!!")

        when(v?.id) {
            R.id.button1 -> {
                Toast.makeText(applicationContext, "button 1이 클릭됨", Toast.LENGTH_SHORT).show()
            }
            R.id.button2 -> {
                Toast.makeText(applicationContext, "button 2이 클릭됨", Toast.LENGTH_SHORT).show()
            }
        }
    }
}