package com.dicoding.mysdgapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mysdgapp.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {
    private lateinit var mySdgs: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Sdgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        //installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListSdgs())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.mySdgs.layoutManager = LinearLayoutManager(this)
        val sdgAdapter = SdgAdapter(list)
        binding.mySdgs.adapter = sdgAdapter
        /*
        mySdgs.layoutManager = LinearLayoutManager(this)
        val listSdgAdapter = SdgAdapter(list)
        mySdgs.adapter = listSdgAdapter
        listSdgAdapter.setOnItemClickCallback(object : SdgAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Sdgs) {
                showSelectedSdg(data)
            }
        })
         */
    }

    //toast
    private fun showSelectedSdg(sdgs: Sdgs) {
        Toast.makeText(this, "You chose " + sdgs.name, Toast.LENGTH_SHORT).show()
    }

    private fun getListSdgs(): Collection<Sdgs> {
        val dataName = resources.getStringArray(R.array.data_sdg_name)
        val dataDescription = resources.getStringArray(R.array.data_sdg_desc)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listSdgs = ArrayList<Sdgs>()

        for (i in dataName.indices) {
            val sdgs = Sdgs(dataName[i], dataDescription[i], dataPhoto[i])
            listSdgs.add(sdgs)
        }
        return listSdgs
    }

    //menu grid or list
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


}