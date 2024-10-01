def lazy_f(c: Boolean, i: =>Int): Int = {
  lazy val iv = i
  if (c) 0
  else iv * iv
}

def val_f(c: Boolean, i: =>Int): Int = {
  def iv = i
  if (c) 0
  else iv * iv
}

@main def lazy_val(): Unit =
  lazy_f(true, {println("eval1"); 100 + 100}) // not printed (not evaluated)
  lazy_f(false, {println("eval2"); 5 + 5}) // evaluated once

  val_f(true, {println("eval3"); 100 + 100}) // not printed (not evaluated)
  val_f(false, {println("eval4"); 5 + 5}) // evaluated twice
