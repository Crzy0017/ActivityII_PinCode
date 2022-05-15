package com.example.pc

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val share: Button = findViewById(R.id.share)
        share.setOnClickListener() {
            val shareInt = Intent(Intent.ACTION_SEND)
            shareInt.type = "text/plain"
            shareInt.putExtra(Intent.EXTRA_TEXT, "full-name: ${getString(R.string.fullname)} " +
                    "gmail: ${getString(R.string.gmail)}  telephone-number: 8-777-555-1188")
            startActivity(Intent.createChooser(shareInt, "share"))
        }

        val gmail: Button = findViewById(R.id.mail)
        gmail.setOnClickListener() {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            startActivity(Intent.createChooser(emailIntent, "Gmail"))
        }

        val call: Button = findViewById(R.id.call)
        call.setOnClickListener() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            startActivity(callIntent)
        }

        val cam: Button = findViewById(R.id.cam)
        cam.setOnClickListener() {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }

}
