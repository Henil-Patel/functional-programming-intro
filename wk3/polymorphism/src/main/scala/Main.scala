package week3

trait List[T]:
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

class Cons[T](val head: T, val tail: List[T]) extends List[T]:
  def isEmpty: Boolean = false

end Cons

class Nil[T] extends List[T]:
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")

end Nil

def singleton[T](elem: T) = Cons[T](elem, Nil[T])

/*
  Exercise: 
    Write a function nth that takes a list and an integer n
    and selects the n'th element of the list.
  
*/

def nth[T](xs: List[T], n: Int): T = 
  if xs.isEmpty then throw java.lang.IndexOutOfBoundsException()
  else if n == 0 then xs.head
  else nth(xs.tail, n-1)


@main def hello: Unit = 
  //println(singleton[Int](1))
  //println(singleton[Boolean](true))
  println(nth(Cons(1, Cons(2, Cons(3, Nil()))), 2)) // Should print 3
