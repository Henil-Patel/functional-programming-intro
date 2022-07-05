package funsets

object Main extends App:
  import FunSets.*
  println(contains(singletonSet(1), 1))
  println(contains(union(singletonSet(1), singletonSet(2)), 2))
  println(contains(intersect(singletonSet(1), singletonSet(2)), 2))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = map(union(s1, s2), x => x + 2)
  println(contains(s3, 4))


