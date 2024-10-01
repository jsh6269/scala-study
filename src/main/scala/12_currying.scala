@main def currying(): Unit =
  def sum(f: Int=>Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a <= b) f(a) + sumF(a+1, b) else 0
    sumF _
  }

  def sum_neat(f: Int=>Int)(a: Int, b: Int): Int = 
    if (a <= b) f(a) + sum(f)(a+1, b) else 0

  def sum_neat2(f: Int=>Int): (Int, Int) => Int = 
    (a, b) => if (a <= b) f(a) + sum(f)(a+1, b) else 0

  def sumCubes = sum(n => n*n*n)
  val res1 = sumCubes(1, 5)
  println(res1)

  def sumSquares = sum_neat(n => n*n)
  val res2 = sumSquares(1, 5)
  println(res2)

  def sum_ = sum_neat2(n => n)
  val res3 = sum_(1, 5)
  println(res3)

  def mapReduce(reduce: (Int, Int) => Int, inival: Int)
      (f: Int => Int) (a: Int, b: Int): Int = {
    if (a <= b) reduce(f(a), mapReduce(reduce, inival)(f)(a+1, b))
    else inival
  }
  // need to make a closure since mapReduce is param. code. 
  def _sum_ = mapReduce((x,y) => x+y, 0) _
  // val is better than def. Think about why.
  val product = mapReduce((x,y) => x*y, 1) _

  println(_sum_(n => n)(1, 5))
  println(product(n => n)(1, 5))
