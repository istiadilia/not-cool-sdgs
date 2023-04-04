package com.dicoding.mysdgapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mysdgapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Get to know me"

        // masih bingung gmn munculin about disini
        //binding.profileImage.load(R.string.about_image)
        //binding.profileName.text(R.string.about_name)
        //binding.profileEmail.text(R.string.about_email)
    }
}