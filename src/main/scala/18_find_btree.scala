def find(t: BTree, i: Int): Boolean =
  t match {
    case Leaf() => false
    case Node(v, _, _) if v == i => true
    case Node(_, left, right) => find(left, i) | find(right, i)
  }

@main def find_btree(): Unit =
  val isOne = find(Node(2, Node(1, Leaf(), Leaf()), Node(2, Leaf(), Leaf())), 1)
  println(isOne)
