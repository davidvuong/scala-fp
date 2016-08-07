/**
 * Exercise 3.1
 *
 * Which will be the result of the following match expression?
 */
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}

object Ex3_1 {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42;
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // <- this
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    println(x);
  }
}
