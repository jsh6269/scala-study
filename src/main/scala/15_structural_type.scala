import reflect.Selectable.reflectiveSelectable

@main def structural(): Unit =
  def bar(x: Int) = x + 1

  val gn = 1

  type Foo = {val a: Int; def b: Int; def f(x: Int): Int; val g: Int => Int}

  object foo {
    val a = 1 + 2
    def b = a + 1
    def f(x: Int) = b + x + gn
    val g: Int => Int = bar _
  }

  val foo2: Foo = new {
    val a = 1 + 2
    def b = a + 1
    def f(x: Int) = b + x + gn
    val g: Int => Int = bar _
  }

  println(foo.b)
  println(foo.f(3))

  val ff: Int => Int = foo.f _

  def g(x: Foo) = x.f(3)
  println(g(foo))
  println(g(foo2))
