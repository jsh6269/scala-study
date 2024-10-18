@main def options(): Unit =
  val optInt: Option[Int] = Some(3)
  val optStr: Option[String] = Some("hi")
  
  println(optInt)
  println(optStr)

  val optNoInt: Option[Int] = None
  println(optNoInt)

  optInt match {
    case Some(value) => println(value)
    case None => println("none")
  }

  optNoInt match {
    case Some(value) => println(value)
    case None => println("none")
  }
