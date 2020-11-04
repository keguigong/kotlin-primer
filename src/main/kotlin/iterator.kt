/**
 * 迭代器
 * https://www.kotlincn.net/docs/reference/iterators.html#%E8%BF%AD%E4%BB%A3%E5%99%A8
 */

val numbers = listOf("one", "two", "three", "four")
val numbersIterator = numbers.iterator()

/**
 * 可变迭代器
 * https://www.kotlincn.net/docs/reference/iterators.html#%E5%8F%AF%E5%8F%98%E8%BF%AD%E4%BB%A3%E5%99%A8
 */
val mutableNumbers = mutableListOf("one", "two", "three", "four")
val mutableNumbersIterator = mutableNumbers.iterator()

val mutableListNumbers = mutableListOf("one", "two", "three", "four")
val  mutableListNumbersIterator = mutableListNumbers.listIterator()

fun main() {
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    mutableNumbersIterator.next()
    mutableNumbersIterator.remove()
    println(mutableNumbers)

    mutableListNumbersIterator.next()
    mutableListNumbersIterator.add("two")
    mutableListNumbersIterator.next()
    mutableListNumbersIterator.set("three")
    println(mutableNumbers)
}