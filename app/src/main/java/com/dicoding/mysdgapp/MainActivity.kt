package com.dicoding.mysdgapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var sdgs: RecyclerView
    private val list = ArrayList<Sdgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sdgs = findViewById(R.id.my_sdgs)
        sdgs.setHasFixedSize(true)
    }
}