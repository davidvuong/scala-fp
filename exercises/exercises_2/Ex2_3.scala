/**
 * Exercise 2.3
 *
 * curry converts a function f of 2 arguments into a function of 1 argument that partially applies f.
 */
object Ex2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def main(args: Array[String]): Unit = {
    val f2 = curry((a: Int, b: Int) => a + b);
    println(f2(1)(2));
  }
}
