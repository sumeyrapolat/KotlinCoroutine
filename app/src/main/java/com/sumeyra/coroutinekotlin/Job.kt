package com.sumeyra.coroutinekotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
       val jobOne =launch {
            delay(5000)
            println("JOB ONE")

           val jobTwo = launch {
               delay(3000)
               println("JOB TWO")

           }

       }

        jobOne.invokeOnCompletion {

            println("job one is done")
        }

        jobOne.cancel()
    }
}