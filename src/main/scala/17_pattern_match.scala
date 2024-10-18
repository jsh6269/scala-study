import scala.annotation.tailrec

sealed abstract class IOption
case class INone() extends IOption
case class ISome(some: Int) extends IOption

sealed abstract class BTree
case class Leaf() extends BTree
case class Node(value: Int, left: BTree, right: BTree) extends BTree

def secondElem(xs: IList): IOption =
  xs match {
    case ICons(_, ICons(elem, _)) => ISome(elem)
    case _ => INone()
  }

@main def pattern(): Unit =
  val bt: BTree = Node(3, Node(4, Leaf(), Node(2, Leaf(), Leaf())), Leaf())
  println(bt)

  val a = secondElem(ICons(2, ICons(3, ICons(4, INil()))))
  val b = secondElem(ICons(1, INil()))

  val num = 6
  num % 2 match {
    case 0 => println("even")
    case _ => println("odd")
  }

  println(a)
  println(b)

  def factorial(n: Int): Int =
    n match {
      case 0 => 1
      case _ => n * factorial(n-1)
    }

  def factorial_tail(n: Int): BigInt =
    @tailrec def factorial_helper(n: Int, acc: BigInt): BigInt =
      n match {
        case 0 => acc
        case _ => factorial_helper(n-1, acc*n)
      }
    factorial_helper(n, 1)

  println(factorial(5))
  println(factorial_tail(20))

  def fib(n: Int): Int =
    n match {
      case 0 | 1 => 1
      case _ => fib(n-1) + fib(n-2)
    }
  
  println(fib(10))

  def f(n: Int) =
    n match {
      case 0 | 1 => println("0 or 1")
      case _ if (n < 10 && n % 2 == 0) => println("even # below 10")
      case _ => println("else")
    }
  f(24)
  f(8)
