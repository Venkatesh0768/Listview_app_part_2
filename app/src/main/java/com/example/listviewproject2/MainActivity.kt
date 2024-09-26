package com.example.listviewproject2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView = findViewById<ListView>(R.id.ListView)

        val name = arrayOf("Venky Rapolu" , "Venkatesh Rapolu" , "Vicky" , "Sushi")

        val lastmsg = arrayOf("Kisa hain Bhai" , "How are You?"  , "Fine from my side" , "Let's go the Library")

        val imagId = intArrayOf(R.drawable.pic0 , R.drawable.pic1 ,R.drawable.pic2 ,R.drawable.pic3 )

        val lasttime = arrayOf("7:00 Am" , "8:10 Pm" , "6:00pm" , "5:00Am")

        val PhoneNumber = arrayOf("29933999" , "4455228866" , "9988774455" , "8899774455")

        userArrayList = ArrayList()

        for(eachindex in name.indices){
            val user = User(name[eachindex] ,lastmsg[eachindex] , lasttime[eachindex] , imagId[eachindex] , PhoneNumber[eachindex])
            userArrayList.add(user)
        }

        listView.isClickable =true
        listView.adapter = MyAdapter(this , userArrayList)


        listView.setOnItemClickListener{ parent, view , position , id->

            val usernname =  name[position]
            val phoneNumber1 = PhoneNumber[position]
            val imageId = imagId[position]


            val i= Intent(this , userActivity::class.java)
            i.putExtra("name" , usernname)
            i.putExtra("Number" , phoneNumber1)
            i.putExtra("imgId" , imageId )

            startActivity(i)
        }


    }
}