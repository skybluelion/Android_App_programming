package net.developia.simplemusicplayer

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.widget.Toast


class MusicPlayerService : Service(){

    var mMediaPlayer: MediaPlayer? = null // 미디어 플레이어 객체를 null로 초기화
    var mBinder: MusicPlayerBinder? = MusicPlayerBinder() // 바인더를 반환해 서비스 함수를 쓸 수 있게 합니다

    inner class MusicPlayerBinder : Binder() {
        fun getService(): MusicPlayerService {
            return this@MusicPlayerService
        }
    }

    override fun onCreate() { //서비스가 생성될 때 딱 한 번만 실행
        super.onCreate()
        startForegroundService() // 포그라운드 서비스 시작
    }

    //바인더 반환
    override fun onBind(intent: Intent?): IBinder? { // 바인더 반환
        return mBinder
    }

    // 시작된 상태 / 백그라운드
    /*
    startService()를 호출하면 실행되는 콜백 함수입니다. 이 함수는 반드시 정숫값을 반환. 이값은 서비스를 종료할 때 서비스를 어떻게 유지할 지를 설명
    START_STICKY : 서비스가 종료되면 다시 시작
    START_NOT_STICKY : 서비스가 종료되면 다시 시작하지 않음
    START_REDELIVER_INTENT : 서비스가 종료되면 다시 시작하고 onStartCommand()의 파라미터로 null이 아닌 마지막 Intent를 전달
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId) // 서비스가 종료되면 다시 시작
        return START_STICKY // 서비스가 종료되면 다시 시작
    }

    // 포그라운드 서비스 시작

    @SuppressLint("ForegroundServiceType")
    fun startForegroundService(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val mChannel = NotificationChannel(
                "CHANNEL_ID",
                "CHANNEL_NAME",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        val notification: Notification = Notification.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.baseline_play_arrow_24)
            .setContentTitle("Music Player APP")
            .setContentText("Music Player Running")
            .build()

        startForeground(1, notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            stopForeground(true)
        }
    }

    fun isPlaying() : Boolean {
        return (mMediaPlayer != null && mMediaPlayer?.isPlaying ?: false)
    }

    fun play() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.chocolate)

            mMediaPlayer?.setVolume(1.0f,1.0f);
            mMediaPlayer?.isLooping = true // 반복 여부
            mMediaPlayer?.start()
        } else {
            if(mMediaPlayer!!.isPlaying) {
                Toast.makeText(this, "이미 재생중입니다.", Toast.LENGTH_SHORT).show()
            } else {
                mMediaPlayer?.start() //음악을 재생합니다.
            }
        }
    }

    fun pause() {
        mMediaPlayer?.let {
            if(it.isPlaying) {
                it.pause()
            }
        }
    }

    fun stop() {
        mMediaPlayer?.let {
            if(it.isPlaying) {
                it.stop()
                it.release() // 미디어 플레이어에 할당된 리소스를 해제합니다.
                mMediaPlayer = null
            }
        }
    }
}