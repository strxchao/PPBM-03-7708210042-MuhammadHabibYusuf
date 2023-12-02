package com.example.a7708210042_muhammadhabibyusuf

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Model>()

        list.add(Model("Facebook", "Habib Yusuf", R.drawable.facebook))
        list.add(Model("Twitter", "@mhabibyusuf", R.drawable.xtwitter))
        list.add(Model("Instagram", "@habibyusuf_", R.drawable.instagram))
        list.add(Model("Discord", "strxchao #5222", R.drawable.discord))
        list.add(Model("Steam", "strxchao", R.drawable.steam))

        listView.adapter = MyAdapter(this, R.layout.row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            when (position) {
                0 -> openSocialMedia("https://www.facebook.com/strix.chrysaetos/")
                1 -> openSocialMedia("https://twitter.com/mhabibyusuf")
                2 -> openSocialMedia("https://www.instagram.com/habibyusuf_/")
                3 -> openSocialMedia("https://discord.com/users/strxchao")
                4 -> openSocialMedia("https://steamcommunity.com/id/strxchao/")
            }

            // Tetap tampilkan Toast
            Toast.makeText(
                this@MainActivity,
                "Anda baru saja mengklik ${list[position].title} Account.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun openSocialMedia(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
