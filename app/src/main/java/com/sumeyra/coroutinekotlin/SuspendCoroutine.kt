package com.sumeyra.coroutinekotlin

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
       delay(5000)
        println("in run blocking")
        myFun()
    }
}

suspend fun myFun(){
    coroutineScope {

       delay(3000)
        println("Coroutine Scope")

    }
}