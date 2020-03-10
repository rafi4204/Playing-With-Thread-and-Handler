package com.example.playingwiththreadandhandler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cthread= CThread()
       cthread.start()
        val handler=cthread.handler
        handler.post(object:Runnable{
            override fun run() {
                for ((index, i) in (0..10).withIndex()) {
                    Log.d("activity Thread!!!",i.toString())
                }
            }
        })

    }
}

class CThread : Thread() {
 var handler=Handler()
    override fun run() {

        Looper.prepare()
        for ((index, i) in (0..10).withIndex()) {
            Log.d("Thread:-1!!",i.toString())
        }
        //Looper.loop()
    }

}