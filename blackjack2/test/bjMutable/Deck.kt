package bjMutable

class Deck {
    private val cardsMutable: MutableList<Card> = mutableListOf()

    val cards:List<Card> get() = cardsMutable

    init {
        (0..51).forEach { cardsMutable.add(Card(it)) }
    }

    fun takeCard(): Card = cardsMutable.removeAt(0)

    val size: Int get() = cardsMutable.size

    fun dump() {
        cardsMutable.forEach {
            println(it.name)
        }
    }

    fun shuffle() {
        cardsMutable.shuffle()
    }
}
