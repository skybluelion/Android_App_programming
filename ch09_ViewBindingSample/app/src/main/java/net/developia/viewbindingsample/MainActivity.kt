package net.developia.viewbindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.developia.viewbindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root // 바인딩 객체의 root 뷰 참조
        setContentView(view) //생성한 뷰 설정
    }
}