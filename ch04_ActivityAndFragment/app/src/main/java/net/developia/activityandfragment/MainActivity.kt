package net.developia.activityandfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity.mylifecycle", "MainActivity.onCreate() 수행")
        settingButton()
    }

    private fun settingButton() {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        val buttonExit = findViewById<Button>(R.id.button_exit)
        buttonExit.setOnClickListener {
            Toast.makeText(applicationContext, "앱을 종료합니다", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity.mylifecycle", "MainActivity.onStart() 수행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity.mylifecycle", "MainActivity.onRestart() 수행")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity.mylifecycle", "MainActivity.onResume() 수행")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity.mylifecycle", "MainActivity.onPause() 수행")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity.mylifecycle", "MainActivity.onStop() 수행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity.mylifecycle", "MainActivity.onDestroy() 수행")
    }
}