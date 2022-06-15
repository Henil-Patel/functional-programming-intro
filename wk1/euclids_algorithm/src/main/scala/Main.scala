import scala.annotation.tailrec;

@tailrec
def gcd(x: Int, y: Int): Int = {
  // tail recursion example
  // this means that the function calls itself as the last action
  if y == 0 then x else gcd(y, x % y)
  // this is an iterative process
}

def factorial(n : Int): Int = {
  // not tail recursion
  // the last action is not a call to itself, 
  // there is n to be multiplied after calling itself
  if n == 0 then 1 else n * factorial(n - 1)
}

// TODO: design a tail recursive version of factorial
def factorialt(m : Int, i: Int): Int = {
  if i == 0 then m else factorialt(m * i, i - 1)
}

@main def test: Unit = {
  println(factorialt(6, 5))
}