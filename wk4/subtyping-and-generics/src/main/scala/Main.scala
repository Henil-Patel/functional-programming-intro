// Already seen two forms of polymorphism
  // Subtyping
  // Generics

// Let's look at their interactions
  // bounds
  // variance

/*
  Consider the method assertAllPos which
    - takes an IntSet
    - returns the IntSet itself if all its elements are positive
    - throws an exception otherwise
  
  What would be the best type you can give to assertAllPos?
    - def assertAllPos(s: IntSet): IntSet
    ^ this would work fine in most cases but can we be more precise?
  
  The crucial observation would be this:
    assertAllPos takes Empty sets to Empty sets and 
                       NonEmpty sets to NonEmpty sets
  
*/
// upper bound
def assertAllPos1[S <: IntSet](r: S): S = ???

// lower bound
def assertAllPos2[S >: NonEmpty](r: S): S = ???

// mixed bound
def assertAllPos[S >: NonEmpty <: IntSet](r: S): S = ???

/*
  Notation classification:
    - S <: T means: S is a 'subtype' of T (upper bound)
      - In above example S could be Empty set or NonEmpty set
        both of which are considered 'subtypes' of IntSet
    - S >: T means: S is a 'supertype' of T
*/


/*
  Covariance

  Given:
    NonEmpty <: IntSet
  is
    List[NonEmpty] <: List[IntSet] ?
*/

/*
  The Liskov Substitution Principle tells us when a type can be a subtype of another
    - If A <: B, then everything one can to do with a value of type B one should also
      be able to do with a value of type A
    - Formally, Let q(x) be a property provable about objects x of type B. Then
      q(y) should be provable for objects y of type A where A <: B.

*/


@main def hello: Unit = 
  println("Hello world!")

