package bjMutable

import org.junit.Test
import kotlin.test.assertEquals

class HandTest {

    @Test
    fun test() {
        val h1 = Hand(HandType.Player)
        assertEquals(0, h1.size)

        h1.add(Card(0))
        assertEquals(1, h1.size)
        assertEquals(1, h1.points)

        h1.add(Card(51))
        assertEquals(2, h1.size)
        assertEquals(11, h1.points)

        h1.dump()

    }

}