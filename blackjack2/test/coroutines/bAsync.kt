package coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object AsyncDemo {

    suspend fun doSomeWork(a: Int, b: Int): Int {
        println("doSomeWork 1")
        delay(5000)
        println("doSomeWork 2")
        return a * b
    }

    fun mainRun() {
        val t1 = System.currentTimeMillis()
        runBlocking {
            //1
            val d1: Deferred<Int> = async {
                doSomeWork(2, 3)
            }
            //2

            val d2: Deferred<Int> = async {
                doSomeWork(3, 4)
            }

            val a1 = d1.await()
            val a2 = d2.await()

        }
        val t2 = System.currentTimeMillis()
        println("Delta: " + (t2 - t1))
    }

}


fun main(args: Array<String>) {
    AsyncDemo.mainRun()

}