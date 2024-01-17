package net.developia.qrcodereader

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.google.common.util.concurrent.ListenableFuture
import net.developia.qrcodereader.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //바인딩 변수 생성
    private lateinit var cameraProviderFuture : ListenableFuture<ProcessCameraProvider> //카메라 객체 생성
    private val PERMISSIONS_REQUEST_CODE = 1 //권한 요청 코드
    private val PERMISSIONS_REQUIRED = arrayOf(android.Manifest.permission.CAMERA) //필요한 권한
    private var isDetected = false //바코드가 인식되었는지 확인하는 변수

    override fun onResume() {
        super.onResume()
        isDetected = false
    }

    fun getImageAnalysis(): ImageAnalysis {
        val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
        val imageAnalysis = ImageAnalysis.Builder()
            .build()

        imageAnalysis.setAnalyzer(cameraExecutor,
            QRCodeAnalyzer(object : OnDetectListener {
                override fun onDetect(msg: String) {
                    if(!isDetected){
                        isDetected = true

                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra("msg", msg)
                        startActivity(intent)
                    }
                }
            }))
        return imageAnalysis
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. 뷰 바인딩 설정
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(!hasPermissions(this)){
            requestPermissions(PERMISSIONS_REQUIRED, PERMISSIONS_REQUEST_CODE)
        } else {
            startCamera()
        }

    }

    //권한이 있는지 확인
    fun hasPermissions(context: Context) = PERMISSIONS_REQUIRED.all {
        ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSIONS_REQUEST_CODE){
            if(PackageManager.PERMISSION_GRANTED == grantResults.firstOrNull()){
                Toast.makeText(this@MainActivity, "권한 요청이 승인되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this@MainActivity, "권한 요청이 거부되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    //미리보기와 이미지 분석 시작
    fun startCamera() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this) //카메라 객체 생성
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get() //카메라 객체 가져오기
            val preview = getPreview() //미리보기 객체 가져오기
            val imageAnalysis = getImageAnalysis() //이미지 분석 객체 가져오기
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis) //카메라 객체에 미리보기 객체와 이미지 분석 객체 바인딩
        }, ContextCompat.getMainExecutor(this))
    }

    //미리보기 객체 반환
    fun getPreview() : Preview {
        val preview : Preview = Preview.Builder().build() //미리보기 객체 생성
        preview.setSurfaceProvider(binding.barcodePreview.getSurfaceProvider())
        return preview
    }


}