package bjFunctional

import org.junit.Test
import kotlin.test.assertEquals

class DeckTest {

    @Test
    fun test() {
        val d1 = Deck(shuffle = false)
        assertEquals(52, d1.size)

//        val pair1: Pair<Deck, List<Card>> = d1.takeCards(1)
//        val pair = d1.takeCards(1)

        val (d2, cards2) = d1.takeCards(1)   //destructuring

//        val d2 = pair.first
//        val cards = pair.second

        assertEquals(51, d2.size)
        assertEquals(1, cards2.size)
        assertEquals(0, cards2[0].index)

        val (d3, cards3) = d2.takeCards(2)
        assertEquals(49, d3.size)
        assertEquals(2, cards3.size)
        assertEquals(1, cards3[0].index)
        assertEquals(2, cards3[1].index)

//        d1.shuffle()
//
//        d1.dump()


    }

    @Test
    fun test2() {

        Deck(shuffle = false).apply {
            assertEquals(52, size)
        }.takeCards(1).run {
            val (deck2, cards) = this
            deck2.run {

            }
            assertEquals(51, deck2.size)
            assertEquals(1, cards.size)
            assertEquals(0, cards[0].index)
            deck2
        }.takeCards(2).let {
            val (deck2, cards) = it
            assertEquals(49, deck2.size)
            assertEquals(2, cards.size)
            assertEquals(1, cards[0].index)
            assertEquals(2, cards[1].index)
            deck2
        }.takeCards(4).let {
            val (deck2, cards) = it
            assertEquals(45, deck2.size)
            assertEquals(4, cards.size)
            assertEquals(3, cards[0].index)
            assertEquals(4, cards[1].index)
            assertEquals(5, cards[2].index)
            assertEquals(6, cards[3].index)
            deck2
        }.shuffled().apply {
            assertEquals(52, size)
            var d = this
            repeat(100) {
                //d = d.takeCards(5).first
                d = d.shuffledIfRunningLow().takeCards(5).first
            }
        }


    }

}