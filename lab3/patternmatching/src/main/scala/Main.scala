case class Person(name: String, age: Int, city: Option[String])

object PatternMatching {
  def main(args: Array[String]): Unit = {
    println("\ntask 1:\n")

    val people = List(
      Person("Joe", 21, Some("Los Angeles")),
      Person("Alice", 25, None),
      Person("Bryan", 16, Some("Austin")),
      Person("David", 15, None)
    )

    def describe(p: Person): String = p match {
      case Person(name, age, Some(city)) if age >= 18 =>
        s"$name, $age y.o. lives in $city, adult"
      case Person(name, age, Some(city)) if age < 18 =>
        s"$name, $age y.o. lives in $city, kid"
      case Person(name, age, None) if age >= 18 =>
        s"$name, $age y.o. homeless adult"
      case Person(name, age, None) if age < 18 =>
        s"$name, $age y.o. homeless kid"
      case _ => "no data"
    }
    people.map(describe).foreach(println)

    println("\ntask 2:\n")

    def handleValue(x: Any): String = x match {
      case n: Int if n % 2 == 0     => s"Even Int: $n"
      case n: Int                   => s"Odd Int: $n"
      case s: String if s.isEmpty() => s"Empty string"
      case s: String                => s"String: $s"
      case p: Person                => s"Person: ${p.name}, ${p.age} y.o."
      case l: List[_]               => s"List of size ${l.size}"
      case Some(v)                  => s"Option with $v"
      case None                     => "None"
      case _                        => "Unknown type"
    }

    val examples: List[Any] =
      List(4, 7, "", "Scala", people.head, List(1, 2, 3), Some(42), None, 3.14)
    examples.foreach(e => println(s"$e => ${{ handleValue(e) }}"))
  }
}
