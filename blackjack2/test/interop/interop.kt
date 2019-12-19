package interop

class Foo(val aaa: Int, val bbb: Int) {
    companion object {

        @JvmStatic
        fun mkHand(): String {
            return "dd"
        }

    }

    @JvmOverloads
    fun f1(a: Int = 3, b: Int = 3, c: Int = 3) {
        println("a = ${a}")
        println("b = ${b}")
        println("c = ${c}")
    }
}

fun main(args: Array<String>) {

    val h = Foo.mkHand()
    val p1 = Person("dave", "ford")

    p1.lastName = "joe"

    println(p1)
}