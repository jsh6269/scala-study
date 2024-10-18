sealed abstract class Attr
case class Name(name: String) extends Attr
case class Age(age: Int) extends Attr
case class DOB(year: Int, month: Int, day: Int) extends Attr
case class Height(height: Double) extends Attr

sealed abstract class IList
case class INil() extends IList
case class ICons(hd: Int, tl: IList) extends IList

@main def algebraic(): Unit =
  val n: Attr = Name("Suhan")
  println(n) // Name(Suhan)
  
  n match {
    case Name(name) => println(name)
    case _ => println("no matching case")
  }

  def b: Attr = DOB(2005, 3, 25)
  println(b)

  val lst: IList = ICons(2, ICons(3, ICons(1, INil())))
  println(lst)

  def gen(n: Int): IList =
    if(n <= 0) INil()
    else ICons(n, gen(n-1))

  println(gen(15))
  
  def len(x: IList): Int =
    x match {
      case INil() => 0
      case ICons(hd, tl) => 1 + len(tl)
    }

  println(len(gen(100)))
