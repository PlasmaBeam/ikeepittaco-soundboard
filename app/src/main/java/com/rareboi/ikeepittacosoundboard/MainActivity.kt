package com.rareboi.ikeepittacosoundboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rareboi.ikeepittacosoundboard.sounds.Sound

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getSounds(): ArrayList<Sound> {
        val sounds = ArrayList<Sound>()

        val labelsList = resources.getStringArray(R.array.labels)
        val idsList = resources.getIntArray(R.array.ids)

        for (i in 0..labelsList.size) {
            sounds[i] = Sound(labelsList.get(i), idsList.get(i))
        }

        return sounds
    }
}
