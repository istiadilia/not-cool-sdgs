package com.dicoding.mysdgapp

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.mysdgapp.databinding.ActivitySdgPageBinding

class SdgPageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SDG = "extra_sdg"
    }

    private lateinit var binding: ActivitySdgPageBinding
    private lateinit var sdgs: Sdgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // implement layout
        setContentView(R.layout.activity_sdg_page)

        binding = ActivitySdgPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sdgs = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Sdgs>(EXTRA_SDG, Sdgs::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Sdgs>(EXTRA_SDG)!!
        }

        // val sdgs = intent.getParcelableExtra<Sdgs>(EXTRA_SDG)

        if (sdgs != null) {
            binding.pageTitle.text = sdgs.name
            binding.pageType.text = sdgs.type
            binding.pageDescription.text = sdgs.description
            Glide.with(this)
                .load(sdgs.photo)
                .into(binding.pageImage)
            Glide.with(this)
                .load(sdgs.bgPhoto)
                .into(binding.pageImageBg)
        }
    }

    // share action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share_button -> {
                Toast.makeText(this, "Share ${sdgs.name}", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}