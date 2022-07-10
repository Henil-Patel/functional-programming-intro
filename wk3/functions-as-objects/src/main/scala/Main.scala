package scala

@main def hello: Unit = 
  println("Hello world!")
  println(msg)

/*
  Functions are treated as objects in scala
  Function type A => B is just an abbreviation for the class
    scala.Function1[A, B] defined as
*/

trait Function1[A, B]:
  def apply(x: A): B

// functions are objects with apply method
// E.g (x: Int) => x * x
//      expands to

trait Function1[Int, Int]:
  def apply(x: Int) = x * x


// function calls
// val f = (x: Int) => x * x
// f(7)
//      expands to

val f = new Function1[Int, Int]:
  def apply(x: Int) = x * x

  f.apply(7)