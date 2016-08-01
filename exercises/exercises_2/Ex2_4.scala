/**
 * Exercise 2.4
 *
 * Implement uncurry, which reverses the transformation of curry.
 */
object Ex2_4 {
  // NOTE: A => B => C is the same as A => (B => C).
  def uncurry[A,B,C](f: A => (B => C)): (A, B) => C = {
    (a, b) => f(a)(b);
  }

  def main(args: Array[String]): Unit = {
    val f1 = (a: Int) => ((b: Int) => a + b);
    println(uncurry(f1)(1, 2));
  }
}
