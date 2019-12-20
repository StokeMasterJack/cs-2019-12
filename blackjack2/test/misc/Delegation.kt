package misc

class Person3(val d: Int) {

//    val map = MutableMap<String,Int>
//    val mm = MapPropDel(map)

    val firstName: Int = d + d

    val lastName: Int get() = d + d

    val personManager: Int by lazy {
        33
    }


}

interface I1 {
    val d: Int
}

open class C1 : I1 {
    override val d: Int
        get() = 33
}

class C2(val c2: I1) : I1 by c2

class C3 : I1, C1() {

}

fun f1(): () -> Int {

    val x = 33

    fun f2() {

    }

    fun f3(): Int {
        return x
    }

    val ff = {
        x
    }


    return ff
}