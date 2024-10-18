type BSTree[A] = MyBTree[(Int, A)]

@main def bstree(): Unit =
  def lookup[A](t: BSTree[A], key: Int): MyOption[A] =
    t match {
      case MyLeaf() => MyNone()
      case MyNode((k, v), lt, rt) => 
        k match {
          case _ if key == k => MySome(v)
          case _ if key < k => lookup(lt, key)
          case _ => lookup(rt, key)
        }
    }

  def t : BSTree[String] = MyNode((5,"My5"),
    MyNode((4,"My4"), MyNode((2, "My2"), MyLeaf(), MyLeaf()), MyLeaf()),
    MyNode((7,"My7"), MyNode((6, "My6"), MyLeaf(), MyLeaf()), MyLeaf()))
  
  println(lookup(t, 7))
  println(lookup(t, 3))
