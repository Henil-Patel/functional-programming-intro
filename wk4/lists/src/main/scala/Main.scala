
// Example of lists
val fruit: List[String] = List("apples", "oranges", "pears")
val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty: List[Nothing] = List()

// Alternatively using constructors
val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val empty = Nil

/*
  Fundamental operations:
    - head: first element of the list
    - tail: the list composed of all the elements except the first
    - isEmpty: 'true' if the list is empty, 'false' otherwise
*/
// Insertion sort
def isort(xs: List[Int]): List[Int] = xs match
  case List() => List()
  case y :: ys => insert(y, isort(ys))

/*
  Exercise:
    Complete the definition insert sort by filling in the ???
*/

def insert(x: Int, xs: List[Int]): List[Int] = xs match 
  case List() => List(x)
  case y :: ys => 
    if x < y then x :: xs else y :: insert(x, ys)

@main def hello: Unit = 
  println(isort(5::4::6::9::2::Nil))


