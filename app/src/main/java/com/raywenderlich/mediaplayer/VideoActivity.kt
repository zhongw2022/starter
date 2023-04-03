/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.mediaplayer

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_video.*

@RequiresApi(Build.VERSION_CODES.O)
class VideoActivity : AppCompatActivity(), SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener,
    MediaPlayer.OnPreparedListener, MediaPlayer.OnDrmInfoListener {

  private val mediaPlayer = MediaPlayer()
  private lateinit var runnable: Runnable
  private var handler = Handler(Looper.getMainLooper())
  private lateinit var selectedVideoUri: Uri

  companion object {
    const val GET_VIDEO = 123
    const val SECOND = 1000
    const val URL =
        "https://res.cloudinary.com/dit0lwal4/video/upload/v1597756157/samples/elephants.mp4"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_video)
    window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    mediaPlayer.setOnPreparedListener(this)
    mediaPlayer.setOnDrmInfoListener(this)
    video_view.holder.addCallback(this)
    seek_bar.setOnSeekBarChangeListener(this)
    play_button.isEnabled = false

    //TODO(7): Add the code for play button onClick listener
  }

  // TODO(4): Converting seconds to mm:ss format to display on screen

  // TODO(5): Initialize seekBar

  // TODO(6): Update seek bar after every 1 second

  // SurfaceHolder is ready
  override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
    // TODO(1): Add the code that will get executed when surfaceView creates a holder
  }

  // Ignore
  override fun surfaceChanged(surfaceHolder: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

  }

  // Ignore
  override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {

  }

  // For DRM files
  override fun onDrmInfo(mediaPlayer: MediaPlayer?, drmInfo: MediaPlayer.DrmInfo?) {
    //TODO(12): Add the code that will get executed when the DRM info is ready
  }

  // This function gets called when the media player gets ready
  override fun onPrepared(mediaPlayer: MediaPlayer?) {
    //TODO(2): Add the code that will get executed when the media player is ready
  }

  // Update media player when user changes seekBar
  override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    //TODO(8): Add the code that will get executed when the user interacts and changes value of seekBar
  }

  // Ignore
  override fun onStartTrackingTouch(seekBar: SeekBar?) {
  }

  // Ignore
  override fun onStopTrackingTouch(seekBar: SeekBar?) {
  }

  // Create option menu in toolbar
  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.app_menu, menu)
    return true
  }

  // Invoked when an option is selected in menu
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle item selection
    return when (item.itemId) {
      R.id.select_file -> {
        //TODO(9): Add the code that will get executed when the user select the option in menu
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  // Invoked when a video is selected from the gallery
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    //TODO(10): Add the code that will get executed when the video is selected from gallery
  }

  // Release the media player resources when activity gets destroyed
  override fun onDestroy() {
    super.onDestroy()
    //TODO(11): Add the code that will get executed when the activity gets destroyed
  }

  //TODO(3): Create extension properties to get the media player total duration and current duration in seconds
}