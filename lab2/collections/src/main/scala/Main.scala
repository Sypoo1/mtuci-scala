object CollectionsLab {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(list)
    println(list.drop(2))
    println(list.dropWhile(_ < 2))
    println(list.tail)
    println(list.head)
  }
}