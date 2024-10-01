@main def basics(): Unit =
  def a = 1 + (2 + 3)
  def b: Int = 3 + a * 4
  val c: Int = 12 % 5

  println(a)
  println(b)
  println(c)
