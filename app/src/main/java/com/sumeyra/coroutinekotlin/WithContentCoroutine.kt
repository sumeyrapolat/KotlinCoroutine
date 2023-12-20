package com.sumeyra.coroutinekotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {
        launch(Dispatchers.IO) {
            println("Context: ${coroutineContext} " )
            withContext(Dispatchers.Main){
                println("Context: ${coroutineContext}")
            }


        }
    }
}