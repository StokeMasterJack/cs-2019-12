package onYourOwns

fun main(args: Array<String>) {

    fun foo() {
        println("Foo")
    }


    do3Times {
        println("Hello")
    }

    do3Times(::foo)


}

//solution
fun do3Times(f: () -> Unit) {
    f()
    f()
    f()
}