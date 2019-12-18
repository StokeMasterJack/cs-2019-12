package bjFunctional

enum class HandType {
    Dealer, Player
}

class Hand2(val type: HandType, val cards: List<Card>, val isStay: Boolean = false) {

}

class Hand private constructor(val type: HandType, val cards: List<Card>, val isStay: Boolean) {

    constructor(type: HandType) : this(type = type, cards = emptyList(), isStay = false)

    fun stay() = Hand(type = this.type, cards = this.cards, isStay = true)

    infix fun add(c: Card): Hand {
        check(!isDone)
        return Hand(type = this.type, cards = this.cards + c, isStay = this.isStay)
    }

    infix fun add(cards: List<Card>): Hand {
        check(!isDone)
        return Hand(type = this.type, cards = this.cards + cards, isStay = this.isStay)
    }


    operator fun plus(c: Card): Hand = add(c)
    operator fun plus(cards: List<Card>): Hand = add(cards)

    val isEmpty: Boolean get() = size == 0

    val points: Int get() = cards.sumBy { it.points }

    private val p: Int get() = points

    val size: Int get() = cards.size

    fun dump() {
        println("=================")
        println("$name Hand")
        println("=================")
        cards.dump()
        println("=================")
        println(msg)
        println("=================")
        println()
        println()
    }

    fun clear(cards: List<Card> = emptyList()): Hand {
        return Hand(type = this.type, cards = cards, isStay = false)
    }

    val name: String get() = type.name

    val is21 get() = points == 21
    val isBust get() = points > 21

    val isDone: Boolean get() = is21 || isBust || isStay

    val isDealClean: Boolean get() = size == 2 && !isStay

    val msg: String
        get() = when (p) {
            in 0..20 -> "$p points"
            21 -> "Blackjack!"
            in 22..200 -> "Bust!"
            else -> throw IllegalStateException()
        }


}