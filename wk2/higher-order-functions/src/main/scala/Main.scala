/**
* Functions that treat other functions as parameters or return functions are called higher order functions.
* In functional programming languages, functions are first class values i.e, like any other value, function can be passed as a parameter, and returned as a result.
* Example:
*/

@main def run(): Unit = {
  println(sumLinearRec(id,4,9))
}

// This is the classic recursive way
// def sumInts(a: Int, b: Int): Int = {
//   if a > b then 0 else a + sumInts(a+1, b)
// }

// ...Taking sum of cubes
// def sumCubes(a: Int, b: Int): Int = {
//   if a > b then 0 else cube(a) + sumCubes(a + 1, b)
// }

// Can define a more generalized recursive function
def sumLinearRec(f: Int => Int, a: Int, b: Int): Int = {
  if a > b then 0
  else f(a) + sumLinearRec(f, a+1, b)
}

// Helpers
def id(a: Int): Int = a
def factorial(a: Int): Int = if a == 0 then 1 else a * factorial(a - 1)
def cube(x: Int): Int = x * x * x;

// Can rewrite above functions in this way - Higher Order Functions (HO)
def HOsumInts(a: Int, b: Int) = sumLinearRec(id, a, b)
def HOsumCubes(a: Int, b: Int) = sumLinearRec(cube, a, b)
def HOsumFactorials(a: Int, b: Int) = sumLinearRec(factorial, a, b)

// Alternatively...anonymous functions - Anonymous Functions (Anon)
def anonSumInts(a: Int, b: Int) = sumLinearRec(x => x, a, b)
def anonSumCubes(a: Int, b: Int) = sumLinearRec(x => x * x * x, a, b)

// Write tail recursive sum
def sumTailRec(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if a > b then acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}
