package recfun

object Main {
    def main(args: Array[String]) {
        println("Pascal's Triangle")

        for (row <- 0 to 10) {
            for (col <- 0 to row)
                print(pascal(col, row) + " ")
            println()
        }
    }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
        if (r < 0 || c < 0 || c > r) {
            0;
        } else if (c == 0 || (r == c)) {
            1;
        } else {
            pascal(c - 1, r - 1) + pascal(c, r - 1);
        }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
        def countEm(count: Int, tailStr: List[Char]): Int = {
            if (tailStr.isEmpty || count < 0) {
                count;
            } else {
                if (tailStr.head == '(') {
                    countEm(count + 1, tailStr.tail);
                } else if (tailStr.head == ')') {
                    countEm(count - 1, tailStr.tail);
                } else {
                    countEm(count, tailStr.tail);
                }
            }
        }

        val counted = countEm(0, chars);

        if (counted == 0) true else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
        if (money == 0) {
            // We have a solution count towards total.
            1;
        } else if (coins.isEmpty) {
            // This cannot be a solution don't count anything.  There is no
            // way to add to get the total.
            0;
        } else if (coins.head <= money) {
            var count = 0;
            // Add all the solutions where we USE the coin towards the count.
            count += countChange(money - coins.head, coins);
            // Also add all the solutions where we DO NOT use the coin towards the count.
            count += countChange(money, coins.tail);

            count;
        } else {
            // Coin is more than the amount, so ignore it and get the rest of the
            // solutions for the other coins.
            countChange(money, coins.tail);
        }
    }
  }
