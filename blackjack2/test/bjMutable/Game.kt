package bjMutable

class Game(val shuffle: Boolean) {

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

    private var deckInternal = Deck()

    val ph = Hand(HandType.Player)
    val dh = Hand(HandType.Dealer)

    init {
        if (shuffle) {
            deckInternal.shuffle()
        }
    }

    val deck: Deck get() = deckInternal

    fun deal() {
        ph.clear()
        dh.clear()
        if (deck.size < 20) {
            deckInternal = Deck()
            if (shuffle) deckInternal.shuffle()
        }
        ph.add(deckInternal.takeCard())
        ph.add(deckInternal.takeCard())
        dh.add(deckInternal.takeCard())
        dh.add(deckInternal.takeCard())
    }

    fun hit() {
        ph.add(deckInternal.takeCard())
    }

    val isGameOver get() = ph.isDone

    fun dump() {
        ph.dump()
        dh.dump()
    }

    fun stay() {
        ph.isStay = true
        while (!dh.isOverMax) {
            dh.add(deck.takeCard())
        }

    }


}

fun foo(w: HandType?) {
    val n = w?.name
}
