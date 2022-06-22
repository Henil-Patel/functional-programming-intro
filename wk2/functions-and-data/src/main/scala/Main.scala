@main def tester: Unit = 
  val a = Rational(1,2)
  println(a.numer)             // 1
  println(a.denom)             // 2
  //makeString(addRational(Rational(1/2), Rational(5/6)))
  // More use cases
  val m = Rational(1,2)
  val n = Rational(2,3)
  val o = Rational(3,4)

  m.add(n).multiply(o)

class Rational(x: Int, y: Int):

  // auxiliary constructor
  // In this case if we just want to pass one argument i.e 2 = 2/1 technically
  def this(x: Int) = this(x, 1)

  require(y > 0, "denominator must be positive")

  private def gcd(a: Int, b: Int): Int = {
    if b == 0 then a else gcd(b, a % b)
  }
  //private val g = gcd(x, y)
  val numer = x / gcd(x.abs, y)
  val denom = y / gcd(x.abs, y)

  // These are methods
  def add(r: Rational) = {
    Rational(numer * r.denom + denom * r.numer,
             denom * r.denom)
  }

  def less(that: Rational): Boolean = {
    this.numer * that.denom < that.numer * this.denom
  }

  def max(that: Rational): Rational = {
    if this.less(that) then that else this
  }

  def multiply(r: Rational) = {
    (this.numer * r.numer) /  (this.denom * r.denom)
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


// This extends the methods of the main class
// Note that the original class methods cannot be overriden
extension (r: Rational)
  // Note the infix modifier 
  infix def min(s: Rational): Boolean = if s.less(r) then s else r
  infix def abs: Rational = Rational(r.numer.abs, r.denom)
  infix def + (s: Rational): Rational = r.add(s)
  infix def * (s: Rational): Rational = r.multiply(s)


/** Calling infix would be like:
      r min s     instead of        r.min(s)
      r + s       instead of        r.+(s)
      r < s       instead of        r.<(s)
**/


// These are just ordinary functions:


// def addRational(r: Rational, s: Rational): Rational = {
//   Rational(
//     r.numer * s.denom + s.numer * r.denom,
//     r.denom * s.denom
//   )
// }

// def makeString(r: Rational): String = {
//   s"${r.numer}/${r.denom}"
// }