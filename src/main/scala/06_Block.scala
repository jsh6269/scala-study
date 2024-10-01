@main def block(): Unit = 
  def ans = {
    val t = 0
    // g has to be defined before next val keyword
    def f(x: Int) = t + g(x + 1)
    def g(y: Int) = y * y
    val x = f(5) // 0 + g(6) = 36
    val r = {
      val t = 10
      val s = f(5) // 0 + g(6) = 36
      s - t // 36 - 10 = 26
    }
    t + r + x // 0 + 26 + 36 = 62
  }
  println(ans) // 62
