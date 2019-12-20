package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun f1() {

    suspend fun slow(a: Int): Int {
        println("slow")
        delay(1000)
        return a * a
    }

    runBlocking {

        val f: Flow<Int> = flow {

            println("compute")
            val a1 = slow(1)

            emit(a1)

            println("compute")
            emit(4)

            println("compute")
            emit(6)

            println("compute")
            emit(6)

            println("compute")
            emit(6)

        }


//        f.collect {
//            println("consume: $it")
//        }

    }
}


fun main(args: Array<String>) {
    f1()

}






