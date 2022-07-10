@main def tester: Unit = 
  println("Hello world!")
  println(msg)

/**
 * Exercise:
  
    Write a method union for forming the union of two sets.
    You should implement the following abstract class:
*/

abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
end IntSet


object IntSet:
  // No args
  def apply(): IntSet = Empty
  // One arg
  def apply(x: Int): IntSet = Empty.incl(x)
  // Two args
  def apply(x: Int, y: Int): IntSet = Empty.incl(x).incl(y)
// abstract class IntSet:
//   def incl(x: Int): IntSet
//   def contains(x: Int): Boolean

class Empty() extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())
  def union(s: IntSet): IntSet = s
end Empty

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
  def contains(x: Int): Boolean = 
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true
  
  def incl(x: Int): IntSet = 
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this

  def union(s: IntSet): IntSet = 
    left.union(right).union(s).incl(elem)
end NonEmpty

// Singleton Object, reduces redundancy in instantiating new classes
object Empty extends IntSet:
  def contains(x: Int): Boolean = False
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
end Empty

// Creating new data structures from old ones without modifying the old
// are called persistent data structures.


abstract class Base:
  def foo = 1
  def bar: Int

class Sub extends Base:
  // redefine an existing, non-abstract definition using override
  override def foo = 2
  def bar = 3


