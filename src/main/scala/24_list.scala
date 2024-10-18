@main def list_ex(): Unit =
  val a: List[Int] = 2 :: 3 :: 4 :: Nil
  println(a)

  val b: List[String] = Nil
  val c: List[Boolean] = true :: false :: true :: true :: Nil

  println(b)
  println(c)
