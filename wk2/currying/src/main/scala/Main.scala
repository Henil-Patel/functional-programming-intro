@main def tester: Unit = 
  ???
/**
 * Note the example below:
 * Here sum returns a function sumF
 * Therefore (a,b) params can be ignored in signature
 * BUT THEY MUST BE PASSED TO THE FUNCTION WHEN CALLING IT
*/

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if a > b then 0
    else f(a) + sumF(a + 1, b)
  }
  sumF
}

// calling this code would work as sum (f) (a, b)
// sum would then call sumF when returning and use a, b

def sumInts = sum(x => x)           // id func
def sumCubes = sum(x => x * x * x)  // cube func
def sumFactorials = sum(factorial)       // sum of factorial

// Alternatively...can be called like this
// sum(cube)(1,10) or
// (sum(cube))(1,10)

/**
 * Alternate, shorter definition of sum
 * Here we do not have to create a nested function
*/

def sum1(f: Int => Int)(a: Int, b: Int): Int = {
  if a > b then 0 else f(a) + sum1(f)(a+1, b)
}

/** Exercise:
  * 1) Write a product function that calculates the product
  *    of the values of a function for the points on a given
  *    interval.
  * 2) Write factorial in terms of product.
  * 3) Can you write a more general function, which 
  *    generalizes both sum and product?
*/
// 1
def product(f: Int => Int)(a: Int, b: Int): Int = {
  if a > b then 1 else f(a) * product(f)(a+1, b)
}

// 1 alt
def product_nest(f: Int => Int):(Int, Int) => Int = {
  def prodF(a: Int, b: Int): Int = {
    if a > b then 1
    else f(a) * prodF(a + 1, b)
  }
  prodF
}

// 2
def factorial(n: Int): Int = {
  product(x => x)(1, n)
}

// 3
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  def recur(a: Int): Int = {
    if a > b then zero
    else combine(f(a), recur(a+1))
  }
  recur(a)
}

def sum(f: Int = Int) = mapReduce(f, (x, y) => x + y, 0)
// sum(fact)(1,10)
def product(f: Int = Int) = mapReduce(f, (x, y) => x*y, 1)
// product(id)(1,6)