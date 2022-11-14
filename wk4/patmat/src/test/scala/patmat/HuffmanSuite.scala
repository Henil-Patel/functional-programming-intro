package patmat

class HuffmanSuite extends munit.FunSuite:
  import Huffman.*

  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    
  }


  test("weight of a larger tree (10pts)") {
    new TestTrees:
      assertEquals(weight(t1), 5)
  }


  test("chars of a larger tree (10pts)") {
    new TestTrees:
      assertEquals(chars(t2), List('a','b','d'))
  }

  test("string2chars hello world") {
    assertEquals(string2Chars("hello, world"), List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times") {
    val l1 = List('a', 'b', 'c')      // to check order
    val l2 = List('a', 'b', 'a')      // to check duplicates
    assertEquals(times(l2), List(('a', 2), ('b', 1)))
  }


  test("make ordered leaf list for some frequency table (15pts)") {
    assertEquals(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))), List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list (15pts)") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assertEquals(combine(leaflist), List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("check until iterator") {
    val inList = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assertEquals(until(singleton, combine)(inList), List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x', 4), List('e', 't', 'x'), 7)))
  }

  test("check correct CodeTree is created") {
    val chars = List('a', 'a', 'a', 'b', 'c')
    assertEquals(createCodeTree(chars), Fork(Fork(Leaf('b', 1), Leaf('c', 1), List('b', 'c'), 2), Leaf('a', 3), List('b', 'c', 'a'), 5))
  }

  test("just decode") {
    val bits = List(0, 1, 0, 0, 1)      // translates to "BAD" in t2
    val verify = List('b', 'a', 'd')
    //println(decode(Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9), bits))
    assertEquals(decode(Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9), bits), verify)
  }

  test("decode and encode a very short text should be identity (10pts)") {
    new TestTrees:
      assertEquals(decode(t1, encode(t1)("ab".toList)), "ab".toList)
  }


  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
