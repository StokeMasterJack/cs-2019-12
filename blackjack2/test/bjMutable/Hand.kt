package bjMutable

//var ff:()->Int = {
//
//}
//
//fun sumBy(f:(c:Card)->Int)

fun mySumBy(c: Card): Int {
    return c.points
}

enum class HandType {
    Dealer, Player
}

class Hand(val type: HandType) {
    private val cardsMutable = mutableListOf<Card>()

    val cards: List<Card> get() = cardsMutable

    var isStay: Boolean = false

    fun add(c: Card) {
        check(!isDone)
        cardsMutable.add(c)
    }

    val points: Int get() = cardsMutable.sumBy { it.points }

    private val p: Int get() = points

    val size: Int get() = cardsMutable.size

    fun dump() {
        println("=================")
        println("$name Hand")
        println("=================")
        cardsMutable.forEach {
            println(it.name)
        }
//        println("isOverMax = ${isOverMax}")
//        println("isDone = ${isDone}")

        println("=================")
        if (type == HandType.Player) {
            println("isStay = $isStay")
        }
        println(msg)
        println("=================")
        println()
        println()
    }

    fun clear() {
        cardsMutable.clear()
        isStay = false
    }

    val name: String get() = type.name

    //msg read only property msg
    //  12 points
    //  Blackjack!   //if points = 21
    //  Bust!   //if points > 21

    val msg: String
        get() = when (p) {
            in 0..20 -> "$p points"
            21 -> "Blackjack!"
            in 22..200 -> "Bust!"
            else -> throw IllegalStateException()
        }

    val isOverMax: Boolean
        get() = when (type) {
            HandType.Player -> points >= 21
            HandType.Dealer -> points >= 17
        }

    val isDone: Boolean
        get() = when {
            isOverMax -> true
            isStay -> true
            else -> false
        }

}