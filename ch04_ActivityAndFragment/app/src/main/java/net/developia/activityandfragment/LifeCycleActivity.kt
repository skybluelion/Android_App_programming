package net.developia.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d("mylifecycle", "onCreate() 수행")

    }

    override fun onStart() {
        super.onStart()
        Log.d("mylifecycle", "onStart() 수행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mylifecycle", "onRestart() 수행")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mylifecycle", "onResume() 수행")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mylifecycle", "onPause() 수행")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mylifecycle", "onStop() 수행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mylifecycle", "onDestroy() 수행")
    }
}