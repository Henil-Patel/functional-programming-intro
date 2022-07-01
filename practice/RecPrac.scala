// A comment!
/* Another Comment */
/** Documentation Comment */

object RecPrac {
    def abs(n: Int): Int = {
        if (n < 0) then -n else n
    }

    def factorial(n: Int): Int = {
        def go(n: Int, acc: Int): Int = {
            if (n == 0) then 1
            else go(n-1, n*acc)
        }
        go(n, 1)
    }

    def fibonacci(n: Int): Int = {
        if (n <= 0) then 1
        else fibonacci(n - 2) + fibonacci(n - 1)
    }

    def formatResult(name: String, n: Int, f: Int => Int) = {
        val msg = "The %d of %d is %d"
        msg.format(name, n, f(n))
    }
    
}