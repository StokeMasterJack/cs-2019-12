package bjFunctional


/*
transformIf1's arg2 type:  (T)  -> (T)
transformIf2's arg2 type:  T.()    -> (T)
 */

fun <T> T.transformIf1(test: Boolean, transform: (T) -> T): T {
    return if (test) transform(this) else this
}

fun <T> T.transformIf2(test: Boolean, transform: T.() -> T): T {
    return if (test) this.transform() else this
}

fun <E> List<E>.dump() = forEach(::println)

fun <E> List<E>.shuffledIf(shuffle: Boolean) = if (shuffle) shuffled() else this