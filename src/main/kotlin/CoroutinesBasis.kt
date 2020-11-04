/**
 * 协程基础
 * https://www.kotlincn.net/docs/reference/coroutines/basics.html
 */
import kotlinx.coroutines.*

fun main() = runBlocking {
	launch { // 在后台启动一个新的协程并继续
		delay(200L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
		println("Task from runBlocking") // 在延迟后打印输出
	}

	coroutineScope { // 创建一个协程作用域
		launch {
//			delay(500L)
//			println("Task from nested launch")
			doWorld()
		}

		delay(100L)
		println("Task from coroutine scope")
	}

	println("Coroutine scope is over")

//	repeat(100_000) { // 启动大量的协程
//		launch {
//			delay(5000L)
//			print(".")
//		}
//	}

//	Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
//	runBlocking {     // 但是这个表达式阻塞了主线程
//		delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
//	}
//	job.join()
}

suspend fun doWorld() {
	delay(1000L)
	println("Task from suspended fun")
}