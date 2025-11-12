object CollectionsLab {
  def main(args: Array[String]): Unit = {

    println("\ntask 1:\n")

    val list = List(1, 2, 3)
    println(list)
    println(list.drop(2))
    println(list.dropWhile(_ < 2))
    println(list.tail)
    println(list.head)

    val tuple = ("hi", 12, 4.5F)
    println(tuple)
    println(tuple(0))
    println(tuple.last)


    println("\ntask 2:\n")

    val nums = (1 to 10).toList
    println(nums)

    val words = List("python", "go", "scala", "rust", "javascript", "typescript", "html :D")
    println(words)

    println(nums.map(_ * 2))
    println(words.map(_.toUpperCase()))

    println(nums.filter(_ % 2 == 0))
    println(words.filter(_.length() % 2 == 0))

    println(nums.reduce(_ + _))
    println(words.reduce(_ + "-" + _))


    println("\ntask 3:\n")

    import scala.math.sqrt

    def applyToAll[A, B](sequnce: Seq[A], function: A => B): Seq[B] = {
      sequnce.map(function)
    }

    def applyTwice[A, B, C](sequnce: Seq[A], function1: A => B, function2: B => C): Seq[C] = {
      applyToAll(applyToAll(sequnce, function1), function2)
    }

    println(applyToAll(List(1, 2, 3), _ * 10))
    println(applyTwice(List(-1, -2, -3), _.abs, sqrt(_)))


    println("\ntask 4:\n")

    def normalMultiplyAndDouble(a: Int, b: Int): Int = 2 * a * b

    def curriedMultiplyAndDouble(a: Int)(b: Int): Int = 2 * a * b

    val normalResult = normalMultiplyAndDouble(5, 7)

    val myltiplyByTen = curriedMultiplyAndDouble(5)
    val curiedResult = myltiplyByTen(7)

    val directCurriedCall = curriedMultiplyAndDouble(5)(7)

    println(normalResult)

    println(curiedResult)

    println(directCurriedCall)

    println("\ntask 5:\n")

    val immutableNumbers = List(1, 2, 3)
    val newImmutableNumbers = immutableNumbers :+ 4

    println(immutableNumbers)
    println(newImmutableNumbers)

    import scala.collection.mutable.ListBuffer

    val buf = ListBuffer(1, 2, 3)
    buf += 4

    println(buf)

    val immutableMap = Map("a" -> 1)
    val newImmutableMap = immutableMap + ("b" -> 2)

    println(immutableMap)
    println(newImmutableMap)

    import scala.collection.mutable
    val mutableMap = mutable.Map("a" -> 1)
    mutableMap("b") = 2

    println(mutableMap)
  }
}