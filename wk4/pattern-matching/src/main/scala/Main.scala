/*
  Introducing pattern matching as an fp alternative to 
  decomposition.

  RECALL:
    The task we are trying to solve is find a general and 
    convenient way to access heterogeneous data in a class
    hierarchy
  
  Scala uses 'case class' definition to handle decomposition.
*/
trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(name: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)


/*
  Exercise 1: 
    Write a function 'show' that uses pattern matching
    to return the representation of a given expression as a
    string.
*/  
def show(e: Expr): String = e match
  case Number(n) => n.toString
  case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
  case Var(x) => x
  case Prod(e1, e2) => s"${showP(e1)} * ${showP{e2}}"

/*
  Exercise 2:
    Add case classes 'Var' for variables x & 'Prod' for products x * y 
    as discussed previously.

    Change your show function so that it also deals with products.

    Pay attention to get operator precedence right but to use as few 
    parentheses as possible.
*/
def showP(e: Expr): String = e match 
  case e: Sum => s"(${show(e)})"
  case _ => show(e)


@main def tests: Unit = 
  // Example 1
  println(eval(Sum(Number(1), Number(2))))

  // Example 2
  val Expr = Prod(Sum(Number(1), Number(2)), Var("x"))
  show(Expr)



