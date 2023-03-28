package com.dicoding.mysdgapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

public class MainActivity : AppCompatActivity() {
    private lateinit var mySdgs: RecyclerView
    private val list = ArrayList<Sdgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mySdgs = findViewById(R.id.my_sdgs)
        mySdgs.setHasFixedSize(true)

        list.addAll(getListSdgs())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        mySdgs.layoutManager = LinearLayoutManager(this)
        val listSdgAdapter = ListSdgAdapter(list)
        mySdgs.adapter = listSdgAdapter
        listSdgAdapter.setOnItemClickCallback(object : ListSdgAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Sdgs) {
                showSelectedSdg(data)
            }
        })
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




}