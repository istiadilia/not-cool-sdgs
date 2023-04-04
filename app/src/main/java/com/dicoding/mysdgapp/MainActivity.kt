package com.dicoding.mysdgapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mysdgapp.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {
    private lateinit var mySdgs: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Sdgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListSdgs())
        showRecyclerList()
    }

    // untuk cardview yang di scroll view main activity
    private fun getListSdgs(): ArrayList<Sdgs> {
        val dataName = resources.getStringArray(R.array.data_sdg_name)
        val dataType = resources.getStringArray(R.array.data_sdg_type)
        val dataExplanation = resources.getStringArray(R.array.data_sdg_desc)
        val dataDescription = resources.getStringArray(R.array.data_sdg_content)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataBackground = resources.getStringArray(R.array.data_background)

        val listSdgs = ArrayList<Sdgs>()

        for (i in dataName.indices) {
            val sdgs = Sdgs(
                dataName[i],
                dataType[i],
                dataExplanation[i],
                dataDescription[i],
                dataPhoto[i],
                dataBackground[i]
            )
            listSdgs.add(sdgs)
        }
        return listSdgs
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val sdgAdapter = SdgAdapter(list)
        binding.recyclerView.adapter = sdgAdapter
    }
}