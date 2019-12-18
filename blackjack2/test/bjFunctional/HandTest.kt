package bjFunctional

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HandTest {

    @Test
    fun test() {
        val h1 = Hand(HandType.Player)
        assertEquals(0, h1.size)

        val h2 = h1.add(c = Card(0))
        assertEquals(1, h2.size)
        assertEquals(1, h2.points)
        assertFalse(h2.isStay)

        val h3 = h2.add(cards = listOf(Card(51), Card(50)))
        //A,K,Q
        assertEquals(3, h3.size)
        assertEquals(1 + 10 + 10, h3.points)
        assertFalse(h3.isStay)

        val h4 = h3.stay()
        assertEquals(3, h4.size)
        assertEquals(1 + 10 + 10, h4.points)
        assertTrue { h4.isStay }

        h4.dump()

        val h5 = h4.clear()
        assertEquals(0, h5.size)
        assertFalse(h5.isStay)



    }

}