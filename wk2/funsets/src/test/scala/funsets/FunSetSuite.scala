package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */
  test("singleton set one contains one") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets:
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("intersect contains common elements of each set") {
    new TestSets:
      val s = intersect(union(s1, s2), s2)
      assert(!contains(s, 1), "Intersect 1")
      assert(contains(s, 2), "Intersect 2")
  }
  
  test("diff contains elements exclusively from the non-negated set") {
    new TestSets:
      val s = diff(union(s3, union(s1, s2)), s2)
      assert(!contains(s, 2), "Diff should not contain 2")
      assert(contains(s, 1), "Diff should contain 1")
  }
  
  test("filter contains elements that do satisfy some predicate") {
    new TestSets:
      val s = filter(union(union(s1, s2), s3), x => x < 3)
      assert(contains(s, 1), "Filter contains 1 since 1<3")
      assert(contains(s, 2), "Filter contains 2 since 2<3")
      assert(!contains(s, 3), "Filter should not contain 3 since 3!<3")
  }

  test("forall determines that all elements of a set satisfy a property") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x > 0), "All elements should be larger than 0")
      assert(!forall(s, x => x == 1), "Not all elements are 1")
      assert(!forall(s, x => (x % 2) == 1), "Not all elements are 0")
  }

  test("exists determines that at least one element should satisfy a property") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(exists(s, x => x == 2), "There exists at least one 2 in set")
      assert(!exists(s, x => x > 4), "Not a single element greater than 4")
      assert(exists(s, x => x / 2 == 1), "There exists a single element divisible by 2")
  }

  test("map takes an input set and applies a transformation to produce an output set") {
    new TestSets:
      val s = map(union(union(s1, s2), s3), x => x * 10)
      assert(contains(s, 10), "1 should be multipled by 10 to give 10")
      assert(!contains(s, 40), "since there is no 4, there should not be a multiplier of 10 to give 40")
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
