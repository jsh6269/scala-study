import scala.annotation.tailrec
import scala.util.control.TailCalls._

// tail recursion
def sum_tail(n: Int, acc: Int): Int =
  if (n <= 0)
    acc
  else
    sum_tail(n-1, acc+n)
 
def sum1(n:Int, acc: Int): Int = if (n <= 0) acc else sum1(n-1, acc+n)

def sum_neat(n: Int): Int = {
  @tailrec def sumItr(res: Int, m: Int): Int =
    if (m <= 0) res else sumItr(m+res, m-1)
  sumItr(0, n)
}

@main def tail(): Unit =
  println(sum_tail(1231235, 0))
  println(sum1(1231235, 0))
  println(sum_neat(1231235))

  // mutual recursion
  val res = {
    def sum(acc: Int, n: Int): TailRec[Int] =
      if (n <= 0) done(acc) else tailcall(sum2(n + acc, n-1))
    def sum2(acc: Int, n: Int): TailRec[Int] =
      if (n <= 0) done(acc) else tailcall(sum(2*n + acc, n-1))
    sum(0, 10).result
  }
  def res2 = 10 + 8 + 6 + 4 + 2 + 2 * (9 + 7 + 5 + 3 + 1)

  println(res)
  println(res2)
