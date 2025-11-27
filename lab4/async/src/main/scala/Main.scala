import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object AsyncLab {
  def main(args: Array[String]): Unit = {

    println("\ntask 1:\n")

    println("Start async computation")

    val futureResult = Future {
      val result = (1L to 1_000_000L).sum
      println("Async computations completed")
      result
    }

    futureResult.onComplete {
        case Success(value) => println(s"Result: $value")
        case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

    println("Waiting for result")
    Await.result(futureResult, 5.seconds)
    println("task 1 is done")
  }
}
