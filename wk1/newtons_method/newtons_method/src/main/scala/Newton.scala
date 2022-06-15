@main def sqrt(x: Double) = {

    def square(x: Double) = x * x

    def abs(x: Double): Double = {
        if (x < 0) -x else x
    }

    def sqrtIter(guess: Double, x: Double): Double = {
        if (isGoodEnough(guess,x)) guess
        else sqrtIter(improve(guess, x), x)
    }

    def isGoodEnough(guess: Double, x: Double) = {
        // Traditional "hard boundary"
        val a = abs(guess * guess - x)
        println("Diff between " + guess*guess + " and " + x)
        a < 0.001

        /**
         * The isGoodEnough test is not very precise for small numbers 
         * because:
            1) the number estimated is too large in comparison hence
            the mean is skewed bringing the improved value much closer
            to 0.001 threshold.
            2) the threshold 0.001 has no sensitivity in comparison to numbers
            on the order of 1e-20 or 1e-50.
        * The test leads to non-termination for large numbers because:
            1) the larger floating point values may have a difference larger than
            0.001 and the improved value might be converging to a value greater
            than a value where the difference with the original value is less
            than 0.001. This would be done to maintain the accuracy of the
            floating point number. 
        */

        // A resizing boundary
        val b = abs(square(guess) - x) / x
        b < 0.001

    }

    def improve(guess: Double, x: Double) = {
        (guess + x / guess) / 2
    }

    sqrtIter(1.0, x)

}