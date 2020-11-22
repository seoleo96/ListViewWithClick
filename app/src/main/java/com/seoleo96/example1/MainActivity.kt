package com.seoleo96.example1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.forliatview.view.*

class MainActivity : AppCompatActivity() {
    private val arrayList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listview)
        val list = numbers()
        val adapter = ArrayAdapter(this, R.layout.forliatview, R.id.textview,list)
        listView.adapter = adapter

        listView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, view.textview.text, Toast.LENGTH_SHORT).show()
            val string = view.textview.text.toString()

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("SEND", string)
            startActivity(intent)
        })

    }

    private fun numbers(): ArrayList<String> {
        for (i in 1 until 11) {
            arrayList.add("$i's element")
        }
        return arrayList
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.just_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.justMenuChangename -> {
                Toast.makeText(this, "Change menu", Toast.LENGTH_SHORT).show()
                val intent = Intent()
            }
            R.id.justMenuExit -> {
                Toast.makeText(this, "Exit menu", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
