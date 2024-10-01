def show(x: Int, y: =>Int): Int = 
  println(y)
  x

@main def call_by(): Unit =
  def val1 = show(1, 5)
  val val2 = show(2, 3) // print 3
  println(val1) // print 5, 1
