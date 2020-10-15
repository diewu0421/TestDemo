package com.example.coroutinedemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.Test

import org.junit.Assert.*
import java.lang.System.currentTimeMillis
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        runBlocking {
//            val startTime = currentTimeMillis()
//            val job = launch(Dispatchers.Default) {
//                var nextPrintTime = startTime
//                var i = 0
//                while (i < 5) { // cancellable computation loop
//                    // print a message twice a second
//                    if (currentTimeMillis() >= nextPrintTime) {
//                        println("job: I'm sleeping ${i++} ...")
//                        nextPrintTime += 500L
//                    }
//                }
//            }
//            delay(1300L) // delay a bit
//            println("main: I'm tired of waiting!")
//            job.cancelAndJoin() // cancels the job and waits for its completion
//            println("main: Now I can quit.")
//        }


        runBlocking(context = CoroutineName("runBlocking")) {
//            val job = launch {
//                try {
//                    repeat(1000) {
//                        println("it = $it")
//                        delay(500L)
//                    }
//                } catch (e: Exception) {
//                    println("e = $e")
//                } finally {
//
//                    withContext(NonCancellable) {
//                        println("job: I'm running finally!")
//                        delay(1300L)
//                        println("job: And I've just delayed for 1 sec because I'm non-cancellable.")
//                    }
//
//                }
//            }
//
//            delay(1300L)
//            println("main: I'm tired of waiting!")
//            job.cancelAndJoin()
//            println("over")

//
//            val result = withTimeoutOrNull(1300L) {
//                repeat(2) {
//                    println("it = $it")
//                    delay(500L)
//                }
//                "Done"
//            }
//            println("over ${result}")

//            val result = measureTimeMillis {
//
////                val one = async(start = CoroutineStart.LAZY) { doOneThing() }
////                val two =async(start = CoroutineStart.LAZY) { doTwoThing() }
////                one.start()
////                two.start()
////                println("one + two ${one.await() + two.await()}")
//
//                try {
//
//                    val doThing = doThing()
//                    println("doThing $doThing")
//                } catch (e: ArithmeticException){
//                    println("error ")
//
//                }
//            }
//
//            println("result = ${result}")

            //sampleStart
//            launch { // 运行在父协程的上下文中，即 runBlocking 主协程
//                println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
//            }
//            launch(Dispatchers.Unconfined) { // 不受限的——将工作在主线程中
//                println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
//            }
//            launch(Dispatchers.Default) { // 将会获取默认调度器
//                println("Default               : I'm working in thread ${Thread.currentThread().name}")
//            }
//            launch(newSingleThreadContext("MyOwnThread")) { // 将使它获得一个新的线程
//                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//            }
//            //sampleEnd
//            GlobalScope.launch {
//                println("globalScope launch ${Thread.currentThread().name}")
//            }


            //sampleStart
//            launch(Dispatchers.Unconfined) { // 非受限的——将和主线程一起工作
//                println("Unconfined      : I'm working in thread [${Thread.currentThread().name}]")
//                delay(500)
//                println("Unconfined      : After delay in thread [${Thread.currentThread().name}]")
//            }
//            launch { // 父协程的上下文，主 runBlocking 协程
//                println("main runBlocking: I'm working in thread [${Thread.currentThread().name}]")
//                delay(1000)
//                println("main runBlocking: After delay in thread [${Thread.currentThread().name}]")
//            }
////sampleEnd


//
//            val request = launch {
////                log("launch ${coroutineContext[Job]}")
//                GlobalScope.launch {
//                    println("globalscope")
//                    delay(1000L)
//                    println("still run")
//                }
//
//
//                launch {
//
//                    println("launch son")
//                    delay(1000L)
//                    println("not running")
//                }
//            }
//
//            delay(500L)
//            request.cancel()
//            delay(1000L)
//            println("over")

            // 启动一个协程来处理某种传入请求（request）
//            val request = launch(context = coroutineContext + CoroutineName("zenglw")) {
//                val list = arrayListOf<Job>()
//                repeat(3) { i -> // 启动少量的子作业
//                    val job = launch(Dispatchers.IO + CoroutineName("it = $i"))  {
//                        delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒的时间
//                        log("Coroutine $i is done")
//                    }
//
//                    list.add(job)
//                }
//
////                list.forEach {
////                    it.join()
////                }
//                log("request: I'm done and I don't explicitly join my children that are still active")
//            }
//            request.join() // 等待请求的完成，包括其所有子协程
//            log("Now processing of the request is complete")


            (1..3).asFlow().take(2).onEach { delay(1000) }
                .flatMapConcat {
                    flow {
//                        emit("$it : first")
//                        delay(1000)
//                        emit("$it: last")
                        emit("emit $it")
                    }

                }
                .collect {
                    log("coole $it")
                }

        }
    }
}
fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
suspend fun doOneThing(): Int {
    delay(1000L)
    println("doOneThing")
    return 13

}

suspend fun doTwoThing(): Int {
    delay(1000L)
    println("doTwoThing")
    return 47
}

suspend fun doThing() = coroutineScope {
//    val one =async { doOneThing() }
//    val two = async { doTwoThing() }
//    one.await() + two.await()

    val one = async {
        try {
            delay(Long.MAX_VALUE)
            42
        } finally {
            println("First child was cancelled")
        }
    }

    val two = async<Int> {
        delay(1000L)
        throw ArithmeticException()
    }

    one.await() + two.await()
}
