sealed abstract class MyOption[A]
case class MyNone[A]() extends MyOption[A]
case class MySome[A](some: A) extends MyOption[A]

sealed abstract class MyList[A]
case class MyNill[A]() extends MyList[A]
case class MyCons[A](hd: A, tl: MyList[A]) extends MyList[A]

@main def parametric_type(): Unit =
  def x: MyList[String] = MyCons("hi", MyCons("je", MyNill()))
  def y: MyList[Int] = MyCons(3, MyCons(1, MyNill()))

  println(x)
  println(y)
