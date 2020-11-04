/**
 * 集合概述
 * https://www.kotlincn.net/docs/reference/collections-overview.html#kotlin-%E9%9B%86%E5%90%88%E6%A6%82%E8%BF%B0
 */

fun printAll(strings: Collection<String>) {
    for(s in strings) print("$s ")
    println()
}

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

fun main() {
    val stringList = listOf("one", "two", "one")
    printAll(stringList)

    val stringSet = setOf("one", "two", "three")
    printAll(stringSet)

    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println(shortWords)
}
