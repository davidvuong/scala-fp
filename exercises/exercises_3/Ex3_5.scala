/**
 * Exercise 3.5
 *
 * Implement dropWhile, which removes elements from the List as long as they match a predicate.
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

object Ex3_5 {
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }

  def main(args: Array[String]): Unit = {
    println(dropWhile(List(1, 2, 2, 3, 2, 2, 2, 4), (i: Int) => i % 2 == 0 ))
    println(dropWhile(Nil, (i: Int) => i % 2 == 0 ))
  }
}
