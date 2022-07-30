
/*
  Solution 1 - OO Decomposition
  Assuming you just want to evaluate expressions
*/
trait OODecomp:
  def eval: Int

class Number(n: Int) extends Expr:
  def eval: Int = n

class Sum(e1: Expr, e2: Expr) extends Expr:
  def eval: Int = e1.eval + e2.eval

/*
    Not a good solution because:
        - it Mixes data with operations on the data
        - increases complexity + adds new dependencies
        - makes it easy to add new kinds of data but hard
          to add new kinds of operations
*/