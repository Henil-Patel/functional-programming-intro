/*
  Some types should be covariant whereas others should not
    - A type that accepts mutations of its elements should not be 
      covariant. E.g arrays
    - Immutable types can be covariant ,if some conditions on methods
      are met.
*/

/*
  Definitions
    If C[T] is a parameterized type and A,B are types such that A <: B
    There are three possible relationships between C[A] and C[B]

    C[A] <: C[B] - C is covariant
    C[A] >: C[B] - C is contravariant
    neither C[A] nor C[B] is subtype of the other - C is nonvariant

*/

/*
  Scala allows declaration of variance of a type by annotating
  the type parameter:
*/

//class C[+A] {...}             // C is covariant
//class C[-A] {...}             // C is contravariant
//class C[A] {...}              // C is nonvariant



/*
  Generally we have the following rule for subtyping between function types
    If A2 <: A1 and B1 <: B2 then
    A1 => B1 <: A2 => B2

  So functions are contravariant in their argument type(s)
  and covariant in their result type
*/

/*
  Scala compiler will perform checks to ensure that there are no problematic
  combinations when compiling a class with variance annotations.

  Roughly,
    - Covariant type parameters can only appear in the method results
    - Contravariant type parameters can only appear in the method parameters
    - Invariant type parameters can appear anywhere

*/

@main def hello: Unit = 
  println("Hello world!")
  println(msg)

