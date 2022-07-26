package com.example.uefa_poc.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.uefa_poc.R
import com.example.uefa_poc.repositories.data.PlayerInfo

class PlayerInfoAdapter(private val context: Context,
                        private val dataSet: ArrayList<PlayerInfo>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSet.size
    }

    override fun getItem(position: Int): Any {
        return dataSet[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val rovView = inflater.inflate(R.layout.player_list_view_item_layout, parent, false)
        val name = rovView.findViewById<TextView>(R.id.nameLabel)
        val country = rovView.findViewById<TextView>(R.id.countryLabel)
        val number = rovView.findViewById<TextView>(R.id.numberLabel)
        val photo = rovView.findViewById<ImageView>(R.id.playerPhoto)

        val playerInfo = dataSet[position]

        name.text = playerInfo.name
        country.text = playerInfo.country
        number.text = playerInfo.number
        photo.setImageResource(playerInfo.photo)
        return rovView

    }
}