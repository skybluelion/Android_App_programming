package net.developia.qrcodereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.developia.qrcodereader.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val result = intent.getStringExtra("msg") ?: "데이터가 존재하지 않습니다."

        setUI(result)
    }

    private fun setUI(result: String) {
        //넘어온 QR코드 속 데이터를 텍스트뷰에 설정
        binding.tvContent.text = result
        binding.btnGoBack.setOnClickListener {
            finish() //돌아가기 버튼을 눌러줬을 때 ResultActivity를 종료
        }
    }
}