package funsets

object Main extends App:
  import FunSets.*
  println(contains(singletonSet(1), 1))
  println(contains(union(singletonSet(1), singletonSet(2)), 2))
  println(contains(intersect(singletonSet(1), singletonSet(2)), 2))
  
