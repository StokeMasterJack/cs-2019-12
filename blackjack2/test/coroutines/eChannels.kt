package coroutines4

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

//Dispatchers.Main
//Dispatchers.IO
//Dispatchers.Default

data class Msg(val v: String)

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
object Channels {

    suspend fun mkData(): Msg = withContext(Dispatchers.IO) {
        val i = Random.nextInt()
        delay(1000)
        Msg(i.toString())
    }

    fun mainRun() {

        runBlocking {

            val rCh: ReceiveChannel<Msg> = produce {
                while (true) {
                    val msg1 = mkData()
                    send(msg1)
                    println("msgSent = ${msg1}")
                }
            }

            while (true) {
                val msgReceived = rCh.receive()
                println("msgReceived = ${msgReceived}")
            }

        }


    }


}

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun main(args: Array<String>) {
    println("Channels")
    Channels.mainRun()
}