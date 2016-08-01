/**
 * Exercise 2.5
 *
 * Implement the higher-order function that composes two functions.
 */
object Ex2_5 {
  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }

  def main(args: Array[String]): Unit = {
  }
}
