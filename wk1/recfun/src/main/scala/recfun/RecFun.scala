package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()
    
    println("Balancing parentheses")
    val spi = ":-)".toList
    println(balance(spi))

    println("Counting change")
    val money = 5
    val denominations = List(1,2,3)
    val count = countChange(money, denominations)
    println(count)

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

  /**
   * Cases:
   * 1) row == 0 -> 1 (first element)
   * 2) col == row -> 1 (last element)
   * 3) col != row -> pascal(col-1, row-1) + pascal(col, row-1)
  */
    if (c == r) {
      1
    }
    else if (c == 0) {
      1
    }
    else {
      pascal(c-1, r-1) + pascal(c, r-1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val open = 0;
    def check(chars: List[Char], open: Int): Int = {
      if (chars.isEmpty) {
        open
      }
      else {
        // println(open + " " + chars.head)
        if (chars.head == '(' && open >= 0) {
          check(chars.tail, open+1)
        }
        else if (chars.head == ')' && open >= 0) {
          check(chars.tail, open-1)
        }
        else { 
          check(chars.tail, open)
        }
      }
    }

    val b = check(chars, open)
    if (b != 0) {
      false
    }
    else {
      true
    }
  }

  /**
   * Exercise 3
   */
  // if money = 4 & coins = [1,2] then countChange should return 3
  // 3 ways to dispense change (1+1+1+1, 1+1+2, 2+2)
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      1
    }
    else if (money > 0 && !coins.isEmpty) {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
    else {
      0
    }
  }


