package com.example.ypp.videoplayer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by ypp on 18-8-16.
 */

class MyAdapter(private val context: Context) : RecyclerView.Adapter<MyAdapter.MyHoler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHoler? {
        return null
    }

    override fun onBindViewHolder(holder: MyHoler, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }


    inner class MyHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mName: TextView

        init {
            mName = itemView.findViewById(R.id.name)
        }
    }
}
