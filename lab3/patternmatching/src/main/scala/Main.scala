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

    println("\ntask 3:\n")

    sealed trait Expr
    case class Number(value: Int) extends Expr
    case class Add(a: Expr, b: Expr) extends Expr
    case class Mul(a: Expr, b: Expr) extends Expr

    def eval(expr: Expr): Int = expr match {
      case Number(v) => v
      case Add(a, b) => eval(a) + eval(b)
      case Mul(a, b) => eval(a) * eval(b)
    }

    val expr1 = Add(Number(2), Number(3))
    val expr2 = Mul(Add(Number(3), Number(4)), Number(4))

    println(s"expr1 = $expr1 => result = ${eval(expr1)}")
    println(s"expr2 = $expr2 => result = ${eval(expr2)}")

    println("\ntask 4:\n")

    def identity[A](value: A): A = value
    def swap[A, B](pair: (A, B)): (B, A) = (pair._2, pair._1)
    def filterWith[A](seq: Seq[A], predicate: A => Boolean): Seq[A] =
      seq.filter(predicate)

    println(identity(42))
    println(identity("hello"))

    println(swap("Alice", 30))

    println(filterWith(List(1, 2, 3, 4, 5, 6), x => x % 2 == 0))
    println(filterWith(List("Bob", "Dean", "Mark", "Rob"), s => s.length % 2 == 0))
  }
}
