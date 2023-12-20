package com.sumeyra.coroutinekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Global Scope, runBlocking, CoroutineScope

        //runBlocking
        println("before run blocking")
        runBlocking {
            launch {
                delay(5000)
                println("in runblocking")
            }
        }
        println("after runblocking")

        //---------------------------------

        println("Before Global Scope")
        GlobalScope.launch {
            delay(5000)
            println("in global scope")
        }
        println("After Global Scope")

        //-----------COROUTINE SCOPE---------------------


        runBlocking {
            launch {
                delay(10000)
                println("runblocking")
            }

            coroutineScope {
                launch {
                    delay(2000)
                    println("coroutine scope")
                }
            }

        //------DISPATCHER---------

        runBlocking {
            launch(Dispatchers.Main) {
                println("Main Thread:  ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Default) {
                println("Default Thread:  ${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO) {
                println("IO Thread:  ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread:  ${Thread.currentThread().name}")
            }
        }


    }
}
}