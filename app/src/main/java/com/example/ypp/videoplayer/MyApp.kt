package com.example.ypp.videoplayer

/**
 * Created by ypp on 18-8-16.
 */

class MyApp(private val a: String, private val b: Int) {

    val more: String
        get() = a + b

    val length: Int
        get() = a.length + b

    val hit:Unit
    get() {
        println(a)
    }
}
