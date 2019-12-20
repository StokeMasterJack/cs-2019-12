package onYourOwns

fun main(args: Array<String>) {

    fun foo() {
        println("Foo")
    }

    prof1("prof a") {
        println("aaa")
        Thread.sleep(300)
        println("aaa")
    }

    prof1("prof b") {
        println("bbb")
        println("bbb")
    }

    prof1("foo", ::foo)

}

//solution
fun <T> prof1(label: String, f: () -> T): T {
    val t1 = System.currentTimeMillis()

    val retVal: T = f()

    val t2 = System.currentTimeMillis()
    println("$label delta: " + (t2 - t1))
    return retVal
}



