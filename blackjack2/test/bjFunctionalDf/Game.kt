package bjFunctionalDf

typealias DeckHand = Pair<Deck, Hand>

fun hit(d: Deck, h: Hand, n: Int = 1): DeckHand {
    val (d2, cards) = d.take(n)
    return DeckHand(d2, h + cards)
}

fun hitUntilDealerStay(d: Deck, h: Hand): DeckHand {
    return if (h.isDealerStay)
        DeckHand(d, h.stay())
    else {
        val (d2, h2) = hit(d, h)
        hitUntilDealerStay(d2, h2)
    }
}

class Game private constructor(val deck: Deck, val ph: Hand, val dh: Hand) {

    constructor(shuffle: Boolean = true) : this(deck = Deck(shuffle), ph = Hand.ph(), dh = Hand.dh())

    private fun cp(deck: Deck? = null, ph: Hand? = null, dh: Hand? = null): Game =
        Game(
            deck = deck ?: this.deck,
            ph = ph ?: this.ph,
            dh = dh ?: this.dh
        )

    val winner: HandType?
        get() = when {
            isGameOver -> when {
                ph.points == 21 -> HandType.Player
                ph.points > 21 -> HandType.Dealer
                dh.points > 21 -> HandType.Player
                ph.points >= dh.points -> HandType.Player
                else -> HandType.Dealer
            }
            else -> null
        }


    fun deal(): Game {
        val (deck2, cards) = deck.maybeShuffle().take(4)
        return cp(
            deck = deck2,
            ph = ph.clear(cards.subList(0, 2)),
            dh = dh.clear(cards.subList(2, 4))
        )
    }

    val isDealClean: Boolean get() = ph.isDealClean && dh.isDealClean

    fun hit(): Game {
        val (deck2, ph2) = hit(deck, ph)
        return cp(deck = deck2, ph = ph2)
    }


    val isGameOver get() = ph.isDone && dh.isDone

    fun dump() {
        ph.dump()
        dh.dump()
    }

    fun stay(): Game {
        check(!ph.isStay)
        check(!dh.isStay)
        val ph2 = ph.stay()
        val (deck2, dh2) = hitUntilDealerStay(deck, dh)
        check(ph2.isStay)
        check(dh2.isStay)
        return cp(deck = deck2, dh = dh2, ph = ph2)
    }


}
