/**
 * 取消与超时
 * https://www.kotlincn.net/docs/reference/coroutines/cancellation-and-timeouts.html
 */
import kotlinx.coroutines.*

fun main() = runBlocking {
	/**
	 * 取消协程的执行
	 * https://www.kotlincn.net/docs/reference/coroutines/cancellation-and-timeouts.html#%E5%8F%96%E6%B6%88%E5%8D%8F%E7%A8%8B%E7%9A%84%E6%89%A7%E8%A1%8C
	 */
//	val job = launch {
//		repeat(1000) { i ->
//			println("job: I'm sleeping $i ...")
//			delay(500L)
//		}
//	}
//	delay(2500L) // 延迟一段时间
//	println("main: I'm tired of waiting!")
//	job.cancelAndJoin()
//	println("main: Now I can quit.")

	/**
	 * 使计算代码可以取消
	 * https://www.kotlincn.net/docs/reference/coroutines/cancellation-and-timeouts.html#%E4%BD%BF%E8%AE%A1%E7%AE%97%E4%BB%A3%E7%A0%81%E5%8F%AF%E5%8F%96%E6%B6%88
	 */
//	val startTime = System.currentTimeMillis()
//	val job = launch(Dispatchers.Default) {
//		var nextPrintTime = startTime
//		var i = 0
//		while (isActive) { // 可以被取消的计算循环
//			// 每秒打印消息两次
//			if (System.currentTimeMillis() >= nextPrintTime) {
//				println("job: I'm sleeping ${i++} ...")
//				nextPrintTime += 500L
//			}
//		}
//	}
//	delay(1300L) // 等待一段时间
//	println("main: I'm tired of waiting!")
//	job.cancelAndJoin() // 取消一个作业并且等待它结束
//	println("main: Now I can quit.")

	/**
	 * 在 finally 中释放资源
	 * https://www.kotlincn.net/docs/reference/coroutines/cancellation-and-timeouts.html#%E5%9C%A8-finally-%E4%B8%AD%E9%87%8A%E6%94%BE%E8%B5%84%E6%BA%90
	 */
	val job = launch {
		try {
			repeat(1000) { i ->
				println("job: I'm sleeping $i ...")
				delay(500L)
			}
		} finally {
			withContext(NonCancellable) {
				println("job: I'm running finally")
				delay(1000L)
				println("job: And I've just delayed for 1 sec because I'm non-cancellable")
			}
		}
	}
	delay(1300L) // 延迟一段时间
	println("main: I'm tired of waiting!")
	job.cancelAndJoin() // 取消该作业并且等待它结束
	println("main: Now I can quit.")
}