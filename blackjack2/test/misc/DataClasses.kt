package misc

data class Point(val a: Int, val b: Int) {


}


fun main(args: Array<String>) {
    val d1 = Point(1, 2)
    val d2 = d1.copy(a = 33)

    val (a, b) = d1
}
//free

/*

toString()
hashcode
equals

copy()

 */