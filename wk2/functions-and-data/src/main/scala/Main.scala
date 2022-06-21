@main def tester: Unit = 
  val a = Rational(1,2)
  println(a.numer)             // 1
  println(a.denom)             // 2
  makeString(addRational(Rational(1/2), Rational(5/6)))
  // More use cases
  val m = Rational(1,2)
  val n = Rational(2,3)
  val o = Rational(3,4)

  m.add(n).multiply(o)

class Rational(x: Int, y: Int):
  def numer = x
  def denom = y

  // These are methods
  def add(r: Rational) = {
    Rational(numer * r.denom + denom * r.numer,
             denom * r.denom)
  }

  def multiply(r: Rational) = {
    ???
  }

  override def toString = s"$numer/$denom"

  /**
   * Exercise:
     1. Add a method neg to class Rational that is used
        like this:
          x.neg // evaluates to -x
     2. Add a method subtract to subtract two rationals
     3. With the values of x, y, z given as
        val x = Rational()
        val y = Rational()
        val z = Rational()
        what is the result of x - y - z
  **/

  def neg = Rational(-numer, denom)

  def subtract(r: Rational) = add(r.neg)

end Rational

// These are just functions:


// def addRational(r: Rational, s: Rational): Rational = {
//   Rational(
//     r.numer * s.denom + s.numer * r.denom,
//     r.denom * s.denom
//   )
// }

// def makeString(r: Rational): String = {
//   s"${r.numer}/${r.denom}"
// }