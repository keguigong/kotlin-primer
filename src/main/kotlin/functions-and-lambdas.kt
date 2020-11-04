/**
 * 高阶函数
 * https://www.kotlincn.net/docs/reference/lambdas.html#%E9%AB%98%E9%98%B6%E5%87%BD%E6%95%B0
 */
fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (arr: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    println(accumulator)
    return accumulator
}

val items = listOf(1, 2, 3, 4, 5)

// Lambdas 表达式是花括号括起来的代码块。
val printString = // Lambdas 表达式是花括号括起来的代码块。
        items.fold(0, {
            // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
            acc: Int, i: Int ->
            val result = acc + i
            println("acc = $acc, i = $i, result = $result")
            // lambda 表达式中的最后一个表达式是返回值：
            result
        })

/**
 * 函数类型实例化
 * https://www.kotlincn.net/docs/reference/lambdas.html#%E5%87%BD%E6%95%B0%E7%B1%BB%E5%9E%8B%E5%AE%9E%E4%BE%8B%E5%8C%96
 */
val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
val twoParameters: (String, Int) -> String = repeatFun

fun runTransformation(f: (String, Int) -> String): String {
    return f("Hello", 3)
}

fun main() {
    // lambda 表达式的参数类型是可选的，如果能够推断出来的话：
    val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })

    // 函数引用也可以用于高阶函数调用：
    val product = items.fold(1, Int::times)

    val result = runTransformation(repeatFun)
}