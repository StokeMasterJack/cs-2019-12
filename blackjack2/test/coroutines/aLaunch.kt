package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//light weight
//nice model

//suspend
//resume
suspend fun doSomeWork() {
    println("doSomeWork 1")
    delay(5000)
    println("doSomeWork 2")
}

fun main(args: Array<String>) {
    val t1 = System.currentTimeMillis()
    runBlocking {
        //1
        launch {
            doSomeWork()
        }
        //2

        launch {
            doSomeWork()
        }


    }
    val t2 = System.currentTimeMillis()
    println("Delta: " + (t2 - t1))

}