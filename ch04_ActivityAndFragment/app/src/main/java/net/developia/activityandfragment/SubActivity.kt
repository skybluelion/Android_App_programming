package net.developia.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d("SubActivity.mylifecycle", "SubActivity.onCreate() 수행")
        settingButton()
    }

    private fun settingButton() {
        val buttonClose = findViewById<Button>(R.id.buttonClose)
        buttonClose.setOnClickListener {
            finish()
        }

        val buttonExit = findViewById<Button>(R.id.buttonExit)
        buttonExit.setOnClickListener {
            finishAffinity()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("SubActivity.mylifecycle", "SubActivity.onStart() 수행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SubActivity.mylifecycle", "SubActivity.onRestart() 수행")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SubActivity.mylifecycle", "SubActivity.onResume() 수행")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SubActivity.mylifecycle", "SubActivity.onPause() 수행")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SubActivity.mylifecycle", "SubActivity.onStop() 수행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SubActivity.mylifecycle", "SubActivity.onDestroy() 수행")
    }
}