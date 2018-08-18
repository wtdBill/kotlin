package com.example.ypp.videoplayer

import android.content.pm.ActivityInfo
import android.os.Build
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView

import com.shuyu.gsyvideoplayer.GSYVideoADManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class MainActivity : AppCompatActivity() {
    private var videoPlayer: StandardGSYVideoPlayer? = null
    internal var orientationUtils: OrientationUtils? = null

    private val SOURCE1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar!!
        actionBar.hide()
        videoPlayer = findViewById(R.id.video_player)
        videoPlayer!!.setUp(SOURCE1, true, "测试视频")

        //封面
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(R.mipmap.ic_launcher)
        videoPlayer!!.thumbImageView = imageView
        //title
        videoPlayer!!.titleTextView.visibility = View.VISIBLE
        videoPlayer!!.titleTextView.text = "测试视频"
        //返回键
        videoPlayer!!.backButton.visibility = View.VISIBLE
        //旋转
        orientationUtils = OrientationUtils(this, videoPlayer)

        videoPlayer!!.fullscreenButton.setOnClickListener { orientationUtils!!.resolveByClick() }

        //滑动
        videoPlayer!!.setIsTouchWiget(true)
        //返回键监听
        videoPlayer!!.backButton.setOnClickListener { Log.d(TAG, "onClick: back") }

        videoPlayer!!.startPlayLogic()

    }

    override fun onPause() {
        super.onPause()
        videoPlayer!!.onVideoPause()
    }

    override fun onPostResume() {
        super.onPostResume()
        videoPlayer!!.onVideoResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoADManager.releaseAllVideos()
        if (orientationUtils != null) {
            orientationUtils!!.releaseListener()
        }
    }

    override fun onBackPressed() {
        if (orientationUtils!!.screenType == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            videoPlayer!!.fullscreenButton.performClick()
            return
        }
        //释放
        videoPlayer!!.setVideoAllCallBack(null)
        super.onBackPressed()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            }
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
