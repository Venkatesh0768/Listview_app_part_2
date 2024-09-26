package com.example.listviewproject2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class userActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("Number")
        val Image = intent.getIntExtra("imgId" , R.drawable.pic0)



        val nameTv = findViewById<TextView>(R.id.ptvname)
        val phoneNumberTv = findViewById<TextView>(R.id.ptvnumber)
        val image = findViewById<ImageView>(R.id.profile_image)

        nameTv.text = name
        phoneNumberTv.text = number
        image.setImageResource(Image)

        val btncall =  findViewById<Button>(R.id.btnCall)

        btncall.setOnClickListener {
            val callIntent: Intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$number")
            }
            startActivity(callIntent)
        }


    }
}