package com.example.listviewproject2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MyAdapter(val context : Activity , val arrylist : ArrayList<User>): ArrayAdapter<User> (context ,R.layout.eachitem , arrylist) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem ,null)

        val image = view.findViewById<ImageView>(R.id.profile_image)
        val lastmsg = view.findViewById<TextView>(R.id.tvlastMSG)
        val lasttime = view.findViewById<TextView>(R.id.tvlastTime)
        val name = view .findViewById<TextView>(R.id.tvName)


        image.setImageResource(arrylist[position].imgID)
        lastmsg.text = arrylist[position].lastmsg
        lasttime.text = arrylist[position].lastime
        name.text = arrylist[position].name


        return view
    }
}