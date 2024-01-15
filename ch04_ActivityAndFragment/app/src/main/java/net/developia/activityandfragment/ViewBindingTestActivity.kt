package net.developia.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import net.developia.activityandfragment.databinding.ActivityViewbindingTestBinding

class ViewBindingTestActivity : AppCompatActivity(){

    private lateinit var binding: ActivityViewbindingTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewbindingTestBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_viewbinding_test)
        binding.button1.setOnClickListener {
            Log.d("viewbinding", "button1 clicked")
            Toast.makeText(applicationContext, "button1 clicked", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            Log.d("viewbinding", "button2 clicked")
            Toast.makeText(applicationContext, "button2 clicked", Toast.LENGTH_SHORT).show()
        }
    }

}