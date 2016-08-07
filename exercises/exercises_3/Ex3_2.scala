/**
 * Exercise 3.2
 *
 * Implement the function tail for removing the first element of the list.
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

object Ex3_2 {
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def main(args: Array[String]): Unit = {
    println(tail(Nil))
    println(tail(List(1, 2, 3, 4, 5)))
    println(tail(List(1)))
  }
}
