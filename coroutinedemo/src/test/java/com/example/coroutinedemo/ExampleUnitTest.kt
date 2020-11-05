package com.example.coroutinedemo

import android.renderscript.Sampler
import io.reactivex.Emitter
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.Test

import org.junit.Assert.*
import java.lang.IndexOutOfBoundsException
import java.lang.System.currentTimeMillis
import java.util.concurrent.atomic.AtomicInteger
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


//            runCatching{
//                supervisorScope<String> {
//                    launch {
//                        try {
//                            log("the child is sleeping")
//                            delay(Long.MAX_VALUE)
//                        }finally {
//                            log("child is cancelled")
//                        }
//                    }
//
//                    yield()
//                    log("parent")
//                    throw AssertionError()
//                }
//
//            }.onFailure {
//                log("Caught an assertion error!")
//            }

//            val single = newSingleThreadContext("new")


//            val actor = counterActor()
//            val incCounter = IncCounter
//
//            withContext(Dispatchers.Default) {
//                missRun {
//                    actor.send(incCounter)
//                }
//            }
//
//            val completableDeferred = CompletableDeferred<Int>()
//            actor.send(GetCounter(completableDeferred))
//
//            log("start await")
//            log("count1 = ${completableDeferred.await()}")
//            log("11111111111111111111111111")
//            actor.close()
////            simple().forEach {
//                log("value $it")
//            }

//            launch {
//                for (k in 1..3) {
//
//                    log("I'm not blocked $k")
//                    delay(1000)
//                }
//            }
//
//            simple().collect {
//                log("value $it")
//            }

//            val simple  = simple()
//            log("Calling collect")
//            simple.collect{ log("value111 $it")}
//            log("again")
//            simple.collect { log("value222 $it")}


//            withTimeout(2500L) {
//                simple().collect {
//                    log("value = $it")
//                }
//            }

//            val sample = simple()
//
//            launch {
//                delay(2000L)
//                log("launch")
//            }
//            sample.collect {log("value = $it")}

//            testBlockMain()


//            val startTime = System.currentTimeMillis() // 记录开始时刻
//            (1..3).asFlow().onEach { delay(100) } // 每隔 100 ms 发射一个数值
////                .flatMapConcat { requestFlow(it) }
//                .flatMapMerge(Int.MAX_VALUE) { requestFlow(it) }
////                .flatMapLatest { requestFlow(it) }
//                .collect { value -> // 收集最后结果, 并输出
//                    println("$value at ${System.currentTimeMillis() - startTime} ms from start")

//                }

            suspend fun doOne(): Int {
                delay (1000L)
                return 23
            }

            suspend fun doTwo(): Int {
                delay (1000L)
                return 17
            }

            suspend fun CoroutineScope.missSum() = coroutineScope {
                    val one = async {doOne()}
                val two = async{doTwo()}

                one.await() + two.await()
                }
            val totalTime = measureTimeMillis {

//                val one = doOne()
//                val two = doTwo()
//                log("sum = ${one.await() + two.await()}")
                log("sum time = ${missSum()}")
            }
            log("totaltime = $totalTime")


//            CoroutineScope(CoroutineExceptionHandler{ _, throwable ->
//
//                log("parent error ${throwable}")
//            }+ CoroutineName("myscope") +  Dispatchers.Default ).run {
////             {
//
//                val one = launch(CoroutineExceptionHandler {_, _ ->
//                    log("error")
//                }) {
//                    log("launch one")
//                    throw IllegalAccessError()
//                }
//
//                launch {
//                    try {
//
//                        delay (Long.MAX_VALUE)
//                    } finally {
//                        log("second child is cancelled")
//                    }
//                }
//
//                one.join()
//
//                log("parent is still running")
//
////                launch {
////
////                }
//
//            }
//
////            delay(Long.MAX_VALUE)
////            joinAll()
        }
    }
}
fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // 等待 500 ms
    emit("$i: Second")
}
fun l(it: Any) = log("collect $it")


fun CoroutineScope.testBlockMain() {
    launch {
        for (i in 1..3) {
            delay(1000L)
            log("main $i")
        }
    }
}

fun simple(): Flow<Int> = flow {
//    log("start-------------")
    for (i in 1..3) {
        delay(100L)
//        Thread.sleep(1000L)
//        log("emit $i")
        emit(i)
    }
}

suspend fun simple1(): List<Int> {
    delay(1000L)
    return listOf(1, 2, 3,)
}

//fun simple()  = sequence<Int> {
//
//    for (i in 1..3) {
//       Thread.sleep(1000L)
//        yield(i)
//    }
//}


fun CoroutineScope.counterActor() = actor<CounterMsg> {

    var counter = 0

    for (msg in channel) {

        when (msg) {
            is IncCounter -> {

                counter++
            }
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

sealed class CounterMsg

object IncCounter : CounterMsg()

class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

//@Volatile
//var count = AtomicInteger()
val mutex = Mutex()

var count = 0

suspend fun missRun(action: suspend () -> Unit) {
    val n = 1000
    val k = 10000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    log("time = $time")
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
