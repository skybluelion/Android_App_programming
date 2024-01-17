package net.developia.learningviews

import android.graphics.Outline
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView

class MatrixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // 원형 모양으로 이미지 뷰 설정
        imageView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                // 이미지 크기에 맞는 원형 영역 정의
                val size = Math.min(view.width, view.height)
                outline.setOval(0, 0, size, size)
            }
        }
        imageView.clipToOutline = true

        imageView.setOnClickListener {
            // 360도 회전 애니메이션
            val rotateAnimation = RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            ).apply {
                duration = 1000
                repeatCount = 0
            }
            imageView.startAnimation(rotateAnimation)
        }
    }
}
