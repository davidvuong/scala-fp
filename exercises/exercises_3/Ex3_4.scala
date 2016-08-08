/**
 * Exercise 3.4
 *
 * Generalize tail to the function drop, which removes the first n elements from a list.
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

object Ex3_4 {
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    // `z` keeps track of the result from the previous iteration.
    (1 to n).foldLeft(l) { (z, i) => tail(z) }
  }

  def main(args: Array[String]): Unit = {
    println(drop(List(1, 2, 3, 4, 5), 1))
  }
}
