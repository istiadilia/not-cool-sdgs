package com.dicoding.mysdgapp

import android.content.Intent
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

        binding.backButton.setOnClickListener {
            finish()
        }

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
            binding.pagePredescription.text = sdgs.explanation
            Glide.with(this)
                .load(sdgs.photo)
                .into(binding.pageImage)
            Glide.with(this)
                .load(sdgs.bgPhoto)
                //.transform(new BlurTransformation(10))
                .into(binding.pageImageBg)

            binding.shareButton.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, sdgs.name)
                intent.putExtra(
                    Intent.EXTRA_TEXT, """
                    Hi! Do you know SDG ${sdgs.number}, ${sdgs.name}?
                    Its goal is to ${sdgs.explanation}
                    
                    Find this interesting? Read more at https://sdgs.un.org/
                """.trimIndent()
                )
                startActivity(Intent.createChooser(intent, "Share to: "))
            }
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