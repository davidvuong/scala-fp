/**
 * Exercise 3.3
 *
 * Implement the setHead function for replacing the first element of a list with a different value.
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

object Ex3_3 {
  def setHead[A](head: A, as: List[A]): List[A] = as match {
    case Nil => Cons(head, Nil)
    case Cons(_, _) => Cons(head, as)
  }

  def main(args: Array[String]): Unit = {
    println(setHead(1, Nil))
    println(setHead(0, List(1, 2, 3, 4, 5)))
    println(setHead(0, List(1)))
    println(setHead(Nil, Nil))
    println(setHead(Nil, List(1)))
  }
}
