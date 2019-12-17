package bjFunctionalDf


private fun mkCards(shuffle: Boolean): List<Card> {
    val a = (0..51).map(::Card)
    return a.shuffled(shuffle)
}

typealias Take = Pair<Deck, List<Card>>

//i = nextCard
class Deck private constructor(private val i: Int, private val shuffle: Boolean, private val all: List<Card>) {

    constructor(shuffle: Boolean = true) : this(i = 0, shuffle = shuffle, all = mkCards(shuffle))

    val size: Int get() = all.size - i

    val isEmpty: Boolean get() = i > 51
    val isVirgin: Boolean get() = i == 0

    private fun cp(
        i: Int,
        all: List<Card> = this.all
    ) = Deck(i = i, shuffle = this.shuffle, all = all)


    private fun use(n: Int): Deck = cp(i = this.i + n)
    private fun last(n: Int): List<Card> = all.subList(i, i + n)

    fun take(n: Int = 1): Take = Take(use(n), last(n))

    //    val cards: List<Card> get() = all.filterIndexed { index, _ -> index >= i }
    val cards: List<Card> get() = if (isEmpty) emptyList() else all.subList(i, 52)

    fun dump() {
        cards.dump()
    }

    fun shuffled(): Deck = cp(i = 0, all = all.shuffled(shuffle))
    fun maybeShuffle(min: Int = 20): Deck = if (size < min) shuffled() else this
}
