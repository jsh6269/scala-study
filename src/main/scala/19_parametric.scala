import scala.annotation.tailrec
def id[A](x: A): A = x

@tailrec def applyN[A](f: A => A, n: Int, x: A): A =
  n match {
    case 0 => x
    case _ => applyN[A](f, n-1, f(x))
  }

@main def parametric_polymorphism(): Unit =
  println(id(3))
  println(id("hello"))
  println(id[BTree](Node(2, Leaf(), Leaf())))

  println(applyN((x: Int) => (x + 1), 100, 3))
  println(applyN((x: String) => (x + "!"), 5, "huh"))

  def foo[A, B](f: A => A, x:(A, B)): (A, B) =
    (applyN[A](f, 10, x._1), x._2)

  val res = foo[String, Int]((x: String) => x + "!", ("hi", 4))
  println(res)
