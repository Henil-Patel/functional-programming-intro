@main def hello: Unit = 
  println("Hello world!")
  println(msg)

val xs: List[Int] = List(1, 2, 3, 4)
val ys: List[Int] = List(5, 6, 7, 8)
val n: Int = 4
val x: Int = 2

// Following are methods on lists
val len = xs.length()       // num of elements in xs
val las = xs.last()         // list's last element
val ini = xs.init()         // all elements of xs execpt last one
val tak = xs.take(n)        // a list consisting of the first n elements of xs
val drp = xs.drop(n)        // the rest of the list after taking n elements
val app = xs(n)             // the element of xs at idx n

// Creating new lists 
val zs = xs ++ ys           // concatenate xs and ys
val xr = xs.reverse()       // reverse order of elements in xs
val xu = xs.updated(n, x)   // update value of xs at n with x

// Finding elements
val v = xs.indexOf(x)       // the index of the first element in xs that is x
                            // returns -1 otherwise
val b = xs.contains(x)      // returns boolean true if element found else false


class SomeImplementations():
  def last[T](xs: List[T]): T = xs match
    case List() => throw Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  // last takes steps proportional to num of elements of xs

  def init[T](xs: List[T]): List[T] = xs match
    case List() => throw Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)

extension [T](xs: List[T])
  def ++ (ys: List[T]): List[T] = 
    xs match
      case m :: ms => m :: (ms1 ++ ys)
      case Nil => ys
  // complexity is the length of xs
  def reverse: List[T] = 
    xs match 
      case y :: ys => ys.reverse ++ List(y)
      case Nil => Nil
  // complexity is xs.length * xs.length

// Exercise:
def removeAt[T](n: Int, xs: List[T]): List[T] = xs match 
    case y :: ys => if (n == 0) then ys
                    else y :: removeAt(n-1, ys)
    case Nil => Nil

def flatten(xs: List[Any]): List[Any] = xs match
  case head :: next => flatten(head) ++ flatten(next)
  case Nil => Nil
  case _ => xs :: Nil