package onYourOwns

//fun <T> prof(label: String, f: () -> T): T {
//    val t1 = System.currentTimeMillis()
//
//    val retVal: T = f()
//
//    val t2 = System.currentTimeMillis()
//    println("$label delta: " + (t2 - t1))
//    return retVal
//}

fun do3Times(f: () -> Unit) {

    f()
    f()
    f()

}