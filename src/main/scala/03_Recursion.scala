def sum(n: Int): Int =
  if (n <= 0)
    0
  else
    n + sum(n-1)

def sum_tail(n: Int, acc: Int): Int =
  if (n <= 0)
    acc
  else
    sum_tail(n-1, acc+n)
 
@main def recursion(): Unit =
  println(sum(5))
  print(sum_tail(1231235, 0))
