/**
 * Exercise 2.2
 *
 * Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function.
 */
import scala.annotation.tailrec

object Ex2_2 {
  def isSorted[A](arr: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec def _isSorted(arrSubset: Array[A]): Boolean = {
      if (arrSubset.length == 0 || arrSubset.length == 1) {
        return true;
      }
      if (!ordered(arrSubset(0), arrSubset(1))) {
        return false;
      }
      _isSorted(arrSubset.slice(1, arrSubset.length));
    }
    _isSorted(arr);
  }

  def main(args: Array[String]): Unit = {
    val isOrdered = (a: Int, b: Int) => a <= b;

    println(this.isSorted(Array(1, 5, 3, 4), isOrdered));
    println(this.isSorted(Array(1, 2, 3), isOrdered));
    println(this.isSorted(Array(1, 2, 100), isOrdered));
  }
}
