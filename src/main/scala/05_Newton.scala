def isGoodEnough(guess: Double, x: Double) =
  guess * guess / x > 0.999 && guess * guess / x < 1.001

def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def sqrt(x: Double) =
  sqrtIter(1, x)

@main def newton(): Unit =
  println(sqrt(2))
