import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Success, Failure}

object AsyncLab {

  def runTask1(): Unit = {
    println("\ntask 1:\n")

    val futureResult = Future {
      println("Task 1 - Async computation started")
      Thread.sleep(2000)
      println("Task 1 - Async computation finished")
      42
    }

    val result = Await.result(futureResult, 3.seconds)
    println(s"Task 1 - Result: $result")
    println("Task 1 - Completed")
  }

  def runTask2(): Unit = {
    println("\ntask 2:\n")

    val promise = Promise[Int]()
    val promiseFuture = promise.future

    Future {
      println("Task 2 - Separate thread computation started")
      try {
        val a = 26
        val b = 2
        Thread.sleep(1000)
        val result = a * b
        promise.success(result)
        println("Task 2 - Computation finished, promise fulfilled")
      } catch {
        case e: Exception =>
          promise.failure(e)
          println("Task 2 - Error during computation, promise failed")
      }
    }

    val finalResult = Await.result(promiseFuture, 3.seconds)
    println(s"Task 2 - Promise future result: $finalResult")
    println("Task 2 - Completed")
  }

  def main(args: Array[String]): Unit = {
    runTask1()
    runTask2()
  }
}
