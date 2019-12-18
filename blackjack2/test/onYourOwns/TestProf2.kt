package onYourOwns

typealias VF = () -> Unit
typealias Action<T> = () -> T
typealias On<T> = (T) -> Unit
typealias F<A, T> = (A) -> T

fun <T> prof(label: String, f: Action<T>): T {
    val t1 = System.currentTimeMillis()
    val r: T = f()
    val t2 = System.currentTimeMillis()
    println("$label delta: " + (t2 - t1))
    return r
}

fun main(args: Array<String>) {
    computesNoProf()
    computesWithProf()
}

fun computesNoProf() {
    val i1: Int = compute(1)
    val i2: Int = compute(2)
    foo()
    println(i1 + i2)
}

fun computesWithProf() {
    val i1: Int = prof("c1") { compute(1) }
    val i2: Int = prof("c2") { compute(2) }
    prof("foo") { foo() }
    println(i1 + i2)
}

fun compute(a: Int): Int {
    Thread.sleep(200)
    return a * a
}

