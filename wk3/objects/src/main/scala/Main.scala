package idealized.scala

@main def hello: Unit = 
  println("Hello world!")
  println(msg)


abstract class Boolean extends AnyVal:
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, false)
  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  def unary_!(): Boolean  = ifThenElse(false, true)

  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!())
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!(), x)

/*
  Exercise 1: Provide an implementation operator ==> for class idealized.scala.Boolean
*/
extension (x: Boolean)
  def ==> (y: Boolean) = x.ifThenElse(y, true)


/*
  Exercise 2: Do not use standard numerical classes in this implementation.
  Rather implement a sub-object and a sub-class.
*/
abstract class Nat:
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
end Nat

object Zero extends Nat:
  def isZero: Boolean = true
  def predecessor: Nat = ???
  def successor: Nat = Succ(this)
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = if that.isZero then this else ???
  override def toString = "Zero"
end Zero 

class Succ(n: Nat) extends Nat:
  def isZero: boolean = false
  def predecessor: Nat = n
  def successor: Nat = Succ(this)
  def +(that: Nat): Nat = Succ(n + that)
  def -(that: Nat): Nat = if that.isZero then this else n - that.predecessor
  override def toString = s"Succ($n)"
end Succ
// object true extends Boolean:
//   def ifThenElse[T](t: => T, e: => T) = t

// object false extends Boolean:
//   def ifThenElse[T](t: => T, e: => T) = e
