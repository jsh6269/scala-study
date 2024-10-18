import scala.annotation.tailrec

sealed abstract class MyBTree[A]
case class MyLeaf[A]() extends MyBTree[A]
case class MyNode[A](value: A, left: MyBTree[A], right: MyBTree[A]) extends MyBTree[A]

@main def tailrec_btree(): Unit =
  def find[A](t: MyBTree[A], x: A): Boolean =
    @tailrec def findIter[A](ts: MyList[MyBTree[A]]): Boolean =
      ts match {
        case MyNill() => false
        case MyCons(MyLeaf(), tl) => findIter(tl)
        case MyCons(MyNode(value, _, _), _) if value == x => true
        case MyCons(MyNode(_, l, r), tl) => findIter(MyCons(l, MyCons(r, tl)))
      }
    findIter(MyCons(t, MyNill()))

  val isOne = find(MyNode(2, MyNode(1, MyLeaf(), MyLeaf()), MyNode(2, MyLeaf(), MyLeaf())), 1)
  println(isOne)

  def gen_weird_tree(v: Int, n: Int): MyBTree[Int] =
    @tailrec def genIter(t: MyBTree[Int], m: Int): MyBTree[Int] =
      if (m == 0) t
      else genIter(MyNode(v, t, MyLeaf()), m-1)
    genIter(MyLeaf(), n)

  val res = find(gen_weird_tree(0, 100000), 1)
  println(res)
