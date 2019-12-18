package bjFunctional

/*
    transformIf1's arg2 type:  (T)  -> (T)
    transformIf2's arg2 type:  T.()    -> (T)
 */

private fun mkCards1(shuffle: Boolean): List<Card> = List(52, ::Card).transformIf1(shuffle) { it.shuffled() }
private fun mkCards2(shuffle: Boolean): List<Card> = List(52, ::Card).transformIf2(shuffle) { shuffled() }
private fun mkCards3(shuffle: Boolean): List<Card> = List(52, ::Card).shuffledIf(shuffle)

//fun Deck(shuffle: Boolean = true): Deck {
//    val a = List(52, ::Card)
//    val b = if (shuffle) a.shuffled() else a
//    return Deck(
//        shuffle = shuffle,
//        i = 0,
//        all = b
//    )
//}

class Deck private constructor(private val shuffle: Boolean, private val i: Int, private val all: List<Card>) {

    constructor(shuffle: Boolean = true) : this(
        shuffle = shuffle,
        i = 0,
        all = mkCards1(shuffle)
    )

    val isVirgin: Boolean = size == 52
    val size: Int get() = 52 - i

    fun takeCards(n: Int): Pair<Deck, List<Card>> {
        val cards = all.subList(i, i + n)
        val deck2 = Deck(shuffle, i + n, all)
        return Pair(deck2, cards)
    }

    //maybe skip shuffle depending Deck shuffle constructor arg
    fun shuffled() = Deck(shuffle = shuffle)

    fun shuffledIfRunningLow(): Deck = if (size < 20) shuffled() else this

    val isShuffled: Boolean get() = shuffle


}

