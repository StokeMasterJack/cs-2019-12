package bjMutable

import org.junit.Test
import kotlin.test.assertEquals

class DeckTest {

    @Test
    fun test() {
        val d1 = Deck()
        assertEquals(52, d1.size)

        val c1 = d1.takeCard()
        assertEquals(51, d1.size)

        d1.shuffle()

        d1.dump()



    }

}