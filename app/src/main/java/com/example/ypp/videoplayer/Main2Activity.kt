package com.example.ypp.videoplayer

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.widget.TextView
import com.example.ypp.videoplayer.R.id.name
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    private var mName: TextView? = null
    private val mNunber: Int = 0
    internal var mText: TextView? = null
    private var mTitle: TextView? = null
    private var yy:Person?=null
    private var mm:MyApp?=null
    private var fragmentList:List<Fragment>?=null
    var map:Map<String,String>?=null


    @SuppressLint("ResourceAsColor", "PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val a:String=intent.getStringExtra("aaaa")

        mName = findViewById(R.id.name)
        mName!!.setBackgroundColor(R.color.exo_edit_mode_background_color)
        mName!!.setText(R.string.abc_capital_off)
        mText = TextView(this)
        mName!!.text = "haha"
        mTitle= TextView(this)
        parseStr(getString(R.string.abc_action_bar_home_description))

        name.setOnClickListener {
            print(getString(R.string.abc_action_bar_home_description))
        }

        yy=Person("ypp",23)
        mm= MyApp("ypp",23)


        val ss:String= mm!!.more
        var let:Int=mm!!.length
        let++
        mm!!.hit
        println(ss+let)

        val items= listOf("aa","bb","cc")
        for (item in items){
            println(item)
        }

        for (index in items.indices){
            println(items[index])
        }

        map!!.forEach { (k,v) ->
            print(k+v)
        }

        val x=9
        val y=10;
        if (x in 1..y+1){
            println("hha")
        }
    }


    fun init() {

    }

    fun maxOf(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    fun parseStr(a: Any): Int? {
        println()
        if (a is String) {
            return a.length
        }
        return null
    }

    override fun onResume() {
        super.onResume()
    }
    class MyAdapter(fm:android.support.v4.app.FragmentManager,private val fragmentList:List<Fragment>):FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return fragmentList[position]

        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return fragmentList.size
        }

    }
}
