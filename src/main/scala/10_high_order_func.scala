@main def high_order_func(): Unit =
  def sum(f: Int => Int, n: Int): Int = 
    if (n <= 0) 0 else f(n) + sum(f, n-1)

  def linear(n: Int) = n

  def sumLinear(n: Int) = sum(linear, n)
  def sumSquare(n: Int) = sum((x: Int) => x * x, n)
  def sumCubes(n: Int) = sum(x => x * x * x, n)

  println(sumLinear(5))
  println(sumSquare(5))
  println(sumCubes(5))

  def mapReduce(reduce: (Int, Int) => Int, inival: Int,
    f: Int=>Int, a: Int, b: Int): Int = {
      if (a <= b) reduce(f(a), mapReduce(reduce, inival, f, a+1, b))
      else inival
    }

  def sum_(f: Int => Int, a: Int, b: Int): Int =
    mapReduce((x, y) => x + y, 0, f, a, b)

  def product_(f: Int => Int, a: Int, b: Int): Int =
    mapReduce((x, y) => x * y, 1, f, a, b)
  
  println(sum_(x => x * x, 1, 5))
  println(product_(x => x + 1, 1, 5))
