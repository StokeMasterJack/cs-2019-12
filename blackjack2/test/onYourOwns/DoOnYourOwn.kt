package onYourOwns

import org.junit.Test

fun foo() {
    println("Foo")
}

class DoOnYourOwn {

    /*
    expected output:
        prof a delta: 300ms
        prof b delta: 300ms
        foo delta: 300ms
    */
    @Test
    fun testProfile() {

        prof("prof a") {
            println("aaa")
            println("aaa")
            Thread.sleep(300)
            println("aaa")
            println("aaa")
        }

        prof("prof b") {
            println("bbb")
            println("bbb")
            println("bbb")
            println("bbb")
        }

        prof("foo", ::foo)
    }

    @Test
    fun testProfile2() {

        prof("prof a") {
            println("aaa")
            println("aaa")
            Thread.sleep(300)
            println("aaa")
            println("aaa")
        }

        prof("prof b") {
            println("bbb")
            println("bbb")
            println("bbb")
            println("bbb")
        }

        prof("foo", ::foo)
    }

    /*
    expected output:
        Hello
        Hello
        Hello
        
        Foo
          foo
          foo
          foo
          foo

        Foo
          foo
          foo
          foo
          foo

        Foo
          foo
          foo
          foo
          foo
    */
    @Test
    fun testDo3Times() {

        do3Times {
            println("Hello")
        }

        do3Times(::foo)

    }


}

