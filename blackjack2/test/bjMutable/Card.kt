package bjMutable

fun errMsg(): String {
    return "whoops"
}


val ff: () -> String = ::errMsg

val ff2: () -> String = {
    "whoops"
}

/**
 * @param index 0..51
 * Ace is always 1 point
 */
class Card(val index: Int) {

    init {

//        Button(mod = Height(2.dp) wrap Width(4.dp) wrap Color())
        require(index in 0..51) { "Bad index: $index" }
    }

    private fun computeValue(): Int {
        return index % 13 + 1
    }

//    private fun computeValue2() = index / 4 + 1

//    val value: Int
//        get() {
//            return index / 4 + 1
//        }


    val name: String get() = "$valueName of $suitName"

    //1..13
    val value: Int get() = index % 13 + 1  // index % 13 + 1

    //1..4
    val suit: Int get() = index / 13 + 1

    //warning: subtle bug
    //val suit: Int = index % 4

    val suitName: String
        get() = when (suit) {
            1 -> "Spades"
            2 -> "Hearts"
            3 -> "Clubs"
            4 -> "Diamonds"
            else -> throw IllegalStateException("Bad suit: $suit")
        }

    val valueName: String
        get() = when (value) {
            1 -> "Ace"
            in 2..10 -> value.toString()
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            else -> throw IllegalStateException("Bad value: $value")
        }

    val points: Int
        get() = when (value) {
            in 1..9 -> value
            in 10..13 -> 10
            else -> throw IllegalStateException("Bad value: $value")
        }


}