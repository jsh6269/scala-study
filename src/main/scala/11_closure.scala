@main def closure(): Unit =
  val res1 = {
    val t = 0
    def f : Int => Int = {
      val t = 10
      def g(x: Int) : Int = x + t
      g _
    }
    f(20)
  }
  println(res1) // 30

  val res2 = { 
    val t = 0
    def f(x: =>Int) = t + x
    val r = {
      val t = 10
      f(t*t) // t*t is treated as ()=>t*t
    }
    r
  }
  println(res2) // 100
