/**
 * Some definitions:
    A number x is called a fixed point of a function if:
      f(x) = x
    For some functions f we can locate the fixed points by starting
    with an initial estimate and then by applying f in a repetitive way

      x, f(x), f(f(x)), f(f(f(x)))...
    Until the value does not vary anymore (or the change is small enough)
**/

val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double) = {
  abs((x-y)/ x) < tolerance
}

def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if isCloseEnough(next, guess) then next
    else iterate(next)
  }
  iterate(firstGuess)
}

/**
 * Consider the specification of sqrt function
 *  sqrt(x) = y such that y * y = x
 *  i.e,
 *  sqrt(x) = y such that y = x / y
 * Hence we can write sqrt(x) is a fixed point (y => x / y)
**/


// Writing sqrt(x) in terms of fixedPoint
// This loops forever...due to oscillating behavior
def sqrt(x: Double): Double = fixedPoint(y => x / y)(1.0)

// Better method
// This will converge to a close enough value
def sqrt_with_damper(x: Double): Double = fixedPoint(y => (y + x / y) / 2)(1.0)

// Define a damper
def averageDamp(f: Double => Double)(x: Double): Double = {
  (x + f(x)) / 2
}

def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1.0)

@main def tester: Unit = 
  println("Hello world!")

