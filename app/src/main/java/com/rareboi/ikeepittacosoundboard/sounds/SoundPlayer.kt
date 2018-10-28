package com.rareboi.ikeepittacosoundboard.sounds

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import java.io.IOException

class SoundPlayer(var mContext: Context) {
    private var mPlayer: MediaPlayer? = null

    private val TAG = "SoundPlayer"

    fun playSound(sound: Sound) {
        val resource = sound.resourceId
        if (mPlayer != null) {
            if (mPlayer!!.isPlaying)
                mPlayer!!.stop()
            mPlayer!!.reset()

            try {
                val afd = mContext.resources.openRawResourceFd(resource) ?: return
                mPlayer!!.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                afd.close()
                mPlayer!!.prepare()
            } catch (e: IOException) {
                Log.e(TAG, e.message)
            } catch (e: IllegalArgumentException) {
                Log.e(TAG, e.message)
            } catch (e: SecurityException) {
                Log.e(TAG, e.message)
            }

        } else {
            mPlayer = MediaPlayer.create(mContext, resource)
        }
        mPlayer!!.start()
    }

    fun release() {
        if (mPlayer != null) {
            mPlayer!!.release()
            mPlayer = null
        }
    }
}