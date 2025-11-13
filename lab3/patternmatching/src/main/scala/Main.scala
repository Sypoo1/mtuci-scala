object PatternMatching {
  def main(args: Array[String]): Unit = {
    println("\ntask 1:\n")

    case class Person(name: String, age: Int, city: Option[String])

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

  }
}
