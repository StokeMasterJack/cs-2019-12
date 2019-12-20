package coroutines4

import kotlinx.coroutines.*

//Dispatchers.Main
//Dispatchers.IO
//Dispatchers.Default

//1. compute answer that requires all for values
//2. 5 sec
object Async10SesTo5 {

    suspend fun doSomeWork(a: Int, b: Int): Int = withContext(Dispatchers.IO) {
        println("doSomeWork 1")
        delay(5000)
        println("doSomeWork 2")
        a * b
    }

    fun mainRun() {

        runBlocking {

            val t1 = System.currentTimeMillis()
            coroutineScope {

                val d1: Deferred<Int> = async {
                    doSomeWork(2, 3)
                }

                println(11)

                val d2: Deferred<Int> = async {
                    doSomeWork(3, 4)
                }

                println(22)
                val d3: Deferred<Int> = async {
                    doSomeWork(2, 3)
                }


                println(33)

                val d4: Deferred<Int> = async {
                    doSomeWork(3, 4)
                }

                println(44)


                val a1 = d1.await()
                val a2 = d2.await()
                val a3 = d3.await()
                val a4 = d4.await()

                println("a1 = ${a1}")
                println("a2 = ${a2}")
                println("a3 = ${a3}")
                println("a4 = ${a4}")

                println(a1 + a2 + a3 + a4)

            }

            val t2 = System.currentTimeMillis()
            println("Delta: " + (t2 - t1))
        }

    }


}

fun main(args: Array<String>) {
    println("Async10SesTo5")
    Async10SesTo5.mainRun()
}