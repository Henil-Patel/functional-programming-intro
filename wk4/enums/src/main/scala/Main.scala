// Recall objects. Here the methods are placed inside an object
trait Expr
object Expr:
  case class Var(s: String) extends Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

// Pure definitions like these are called algebraic data types or ADT
// Can use enums as well

enum Expr:
  case Var(s: String)
  case Number(n: Int)
  case Sum(e1: Expr, e2: Expr)
  case Prod(e1: Expr, e2: Expr)

// Can also use match expressions on enums
def show(e: Expr): String = e match 
  case Expr.Var(x) => x
  case Expr.Number(n) => n.toString
  case Expr.Sum(a, b) => s"${show(a)} + ${show(b)}"
  case Expr.Prod(a, b) => s"${showP(a)} + ${showP(b)}"

def showP(e: Expr): String = e match
  case e: Sum => s"(${show(e)})"
  case _ => show(e)

// Simple Enums
enum Color:
  case Red
  case Green
  case Blue

enum DayOfWeek:
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

def isWeekend(day: DayOfWeek) = day match 
  case Saturday | Sunday => true
  case _ => false

// Example 1
enum Direction(val dx: Int, val dy: Int):
  case Right extends Direction(1, 0)
  case Up extends Direction(0, 1)
  case Left extends Direction(-1, 0)
  case Down extends Direction(0, -1)

  def leftTurn = Direction.values((ordinal + 1) % 4)
end Direction


// Example 2 - Modelling payment methods 
enum PaymentMethod:
  case CreditCard(kind: Card, holder: String, number: Long, expires: Date)
  case PayPal(email: String)
  case Cash

enum Card:
  case Visa, Mastercard, Amex

@main def test: Unit = 
  val r = Direction.Right
  val u = r.leftTurn
  val v = (u.dx, u.dy)

