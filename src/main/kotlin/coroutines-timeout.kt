import kotlinx.coroutines.runBlocking

/**
 * 在 finally 中释放资源
 * https://www.kotlincn.net/docs/reference/coroutines/cancellation-and-timeouts.html#%E5%9C%A8-finally-%E4%B8%AD%E9%87%8A%E6%94%BE%E8%B5%84%E6%BA%90
 */
import kotlinx.coroutines.*

fun main() = runBlocking {
	val result = withTimeoutOrNull(1300L) {
		repeat(1000) { i ->
			println("I'm sleeping $i ...")
			delay(500L)
		}
		"Done" // 在它运行得到结果之前取消它
	}
	println("Result is $result")
}