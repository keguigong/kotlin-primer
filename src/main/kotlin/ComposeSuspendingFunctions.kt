/**
 * 组合挂起函数
 * https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html
 */
import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
	val time = measureTimeMillis {
//		val one = doSomethingUsefulOne()
//		val two = doSomethingUsefulTwo()
//		println("The answer is ${one + two}")

		/**
		 * 使用 async 并发
		 * https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html#%E4%BD%BF%E7%94%A8-async-%E5%B9%B6%E5%8F%91
		 */
//		val one = async { doSomethingUsefulOne() }
//		val two = async { doSomethingUsefulTwo() }
//		println("The answer is ${one.await() + two.await()}")

		/**
		 * 惰性启动的 async
		 * https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html#%E6%83%B0%E6%80%A7%E5%90%AF%E5%8A%A8%E7%9A%84-async
		 */
//		val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//		val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
//		one.start() // 启动第一个
//		two.start() // 启动第二个
//		println("The answer is ${one.await() + two.await()}")

		/**
		 * async 风格的函数
		 * https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html#async-%E9%A3%8E%E6%A0%BC%E7%9A%84%E5%87%BD%E6%95%B0
		 */
		// 我们可以在协程外面启动异步执行
		val one = somethingUsefulOneAsync()
		val two = somethingUsefulTwoAsync()
		// 但是等待结果必须调用其它的挂起或者阻塞
		// 当我们等待结果的时候，这里我们使用 `runBlocking { …… }` 来阻塞主线程
		runBlocking {
			println("The answer is ${one.await() + two.await()}")
		}
	}
	println("Completed in $time ms")
}

// async 风格的函数
fun somethingUsefulOneAsync() = GlobalScope.async {
	doSomethingUsefulOne()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
	doSomethingUsefulTwo()
}

suspend fun doSomethingUsefulOne(): Int {
	delay(1000L) // 假设我们在这里做了一些有用的事
	return 13
}

suspend fun doSomethingUsefulTwo(): Int {
	delay(1000L) // 假设我们在这里也做了一些有用的事
	return 29
}