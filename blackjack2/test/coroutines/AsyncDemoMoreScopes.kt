package coroutines1

import kotlinx.coroutines.*

//1. compute answer that requires all for values
//2. 5 sec
//   2a.    uses all 4 values

object AsyncDemoMoreScopes {

    suspend fun doSomeWork(a: Int, b: Int): Int {
        println("doSomeWork 1")
        delay(5000)
        println("doSomeWork 2")
        return a * b
    }

    fun mainRun() {
        val t1 = System.currentTimeMillis()
        runBlocking {

            coroutineScope {

                val d1: Deferred<Int> = async {
                    doSomeWork(2, 3)
                }

                val d2: Deferred<Int> = async {
                    doSomeWork(3, 4)
                }

                val a11 = d1.await()
                val a21 = d2.await()

                println("a11 = ${a11}")
                println("a21 = ${a21}")

            }

            coroutineScope {
                val d1: Deferred<Int> = async {
                    doSomeWork(2, 3)
                }

                val d2: Deferred<Int> = async {
                    doSomeWork(3, 4)
                }

                val a12 = d1.await()
                val a22 = d2.await()

                println("a12 = ${a12}")
                println("a22 = ${a22}")
            }


        }
        val t2 = System.currentTimeMillis()
        println("Delta: " + (t2 - t1))
    }

}

fun main(args: Array<String>) {
    AsyncDemoMoreScopes.mainRun()
}