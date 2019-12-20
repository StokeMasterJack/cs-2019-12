package coroutines

fun main(args: Array<String>) {

    val s: Sequence<Int> = sequence {

        println("compute")
        yield(2)

        println("compute")
        yield(4)

        println("compute")
        yield(6)

        println("compute")
        yield(6)

        println("compute")
        yield(6)

    }

    s.map { it * 2 }.filter { it > 4 }.take(2).forEach {
        println(it)
    }

//    s.forEach {
//        println(it)
//    }

//    while (true){
//
//
//    }


}