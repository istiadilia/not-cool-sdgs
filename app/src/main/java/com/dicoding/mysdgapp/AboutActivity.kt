package com.dicoding.mysdgapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mysdgapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // activate back button
        binding.backButton.setOnClickListener {
            finish()
        }

        supportActionBar?.title = "Get to know me"

        binding.profileName.text = getString(R.string.about_name)
        binding.profileEmail.text = getString(R.string.about_email)
        binding.profileGithub.setOnClickListener {
            val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/istiadilia"))
            startActivity(githubIntent)
        }
    }
}