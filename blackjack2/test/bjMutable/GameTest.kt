package bjMutable

import junit.framework.Assert.assertNull
import org.junit.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/*
hand should throw an illegal state ex if add
 */

class GameTest {

    @Test
    fun test() {

        val g = Game(shuffle = false)
        assertEquals(52, g.deck.size)
        assertEquals(0, g.ph.size)
        assertEquals(0, g.dh.size)

        g.deal()
        assertEquals(48, g.deck.size)
        assertEquals(2, g.ph.size) //ace, 2
        assertEquals(2, g.dh.size) //3, 4
        assertFalse(g.isGameOver)

        g.hit() //ph ace, 2, 5
        assertEquals(47, g.deck.size)
        assertEquals(3, g.ph.size)
        assertEquals(2, g.dh.size)
        assertFalse(g.isGameOver)

        g.hit() //ph: ace, 2, 5, 6
        assertEquals(46, g.deck.size)
        assertEquals(4, g.ph.size)
        assertEquals(2, g.dh.size)
        assertFalse(g.isGameOver)

        g.hit() //ph: ace, 2, 5, 6, 7
        assertEquals(45, g.deck.size)
        assertEquals(5, g.ph.size)
        assertEquals(2, g.dh.size)
        assertTrue(g.isGameOver)

        //*** Next assignment:
        g.deal()
        //ph:  8 9
        //dh:  10 J
        assertEquals(41, g.deck.size)
        assertEquals(2, g.ph.size)
        assertEquals(17, g.ph.points)
        assertEquals(2, g.dh.size)
        assertEquals(20, g.dh.points)
        assertFalse(g.isGameOver)

        assertNull(g.winner)

        g.stay()  //sets ph.stay to true and auto-hits dealer as long dh.points < 17
        //ph:  8 9
        //dh:  10 J
        assertEquals(41, g.deck.size)
        assertEquals(2, g.ph.size)
        assertEquals(17, g.ph.points)
        assertEquals(2, g.dh.size)
        assertEquals(20, g.dh.points)
        assertTrue(g.isGameOver)

        //we will do this one together
//        val tmp: HandType = g.winner!!
        kotlin.checkNotNull(g.winner)

        //tmp type now

//        org.junit.Assert.assertNotNull(g.winner)
        val w: HandType = g.winner!!   //checks for null and throws npe if(g.winner == null) throw NPE



        assertEquals(HandType.Dealer, g.winner)

        g.dump()

    }

}