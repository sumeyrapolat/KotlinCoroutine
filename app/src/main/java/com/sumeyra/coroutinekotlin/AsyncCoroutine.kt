package com.sumeyra.coroutinekotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    var userName =""
    var age=0

    runBlocking {
     val downloadedName = async {
         downloadName()
     }
        val downloadedAge = async {
            downloadAge()
        }

        userName= downloadedName.await()
        age = downloadedAge.await()

        println("${userName}: ${age}")


    }

}

suspend fun downloadName() : String{
    delay(5000)
    val userName ="Sumyera"
    println("username download")
    return userName
}

suspend fun downloadAge(): Int{
    delay(5000)
    val userAge = 23
    println("userage download")
    return userAge

}