import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object AsyncLab {
  def main(args: Array[String]): Unit = {

    println("\ntask 1:\n")

    val futureResult = Future {
      println("Start async computation")
      Thread.sleep(2000)
      println("Async computation completed")
      42
    }

    futureResult.onComplete {
        case Success(value) => println(s"Result: $value")
        case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

    println("Waiting for result")
    Await.result(futureResult, 3.seconds)
    println("task 1 is done")
  }
}
