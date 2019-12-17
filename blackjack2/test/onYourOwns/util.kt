package onYourOwns

fun prof(label: String, f: () -> Unit) {
    val t1 = System.currentTimeMillis()

    f()

    val t2 = System.currentTimeMillis()
    println("$label Delta: " + (t2 - t1))
}

fun do3Times(f: () -> Unit) {

    f()
    f()
    f()

}