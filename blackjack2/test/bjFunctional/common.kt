package bjFunctional

fun List<Card>.shuffled(shuffle: Boolean): List<Card> {
    return if (shuffle) shuffled() else this
}

fun List<Card>.dump() {
    forEach {
        println(it)
    }
}