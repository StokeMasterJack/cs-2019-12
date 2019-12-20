package onYourOwns

typealias VF = () -> Unit
typealias Action<T> = () -> T
typealias On<T> = (T) -> Unit
typealias F<A, T> = (A) -> T



fun main(args: Array<String>) {

    fun foo() {
        println("Foo")
    }

    fun compute(a: Int): Int {
        Thread.sleep(200)
        return a * a
    }

    fun computesNoProf() {
        val i1: Int = compute(1)
        val i2: Int = compute(2)
        foo()
        println(i1 + i2)
    }

    fun computesWithProf() {
        val i1: Int = prof2("c1") { compute(1) }
        val i2: Int = prof2("c2") { compute(2) }
        prof2("foo") { foo() }
        println(i1 + i2)
    }


    computesNoProf()
    computesWithProf()

}

//solution
fun <T> prof2(label: String, f: () -> T): T {
    val t1 = System.currentTimeMillis()

    val retVal: T = f()

    val t2 = System.currentTimeMillis()
    println("$label delta: " + (t2 - t1))
    return retVal
}


