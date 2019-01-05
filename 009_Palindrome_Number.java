// *Solution*: <br>
// Despite the regular "reverse integer" solution, there is one brilliant solution without considering the overflow. <br>
// Reverse half the integer; <br>
// condition: halfRev == num || halfRev / 10 = num; <br>
// tips: for the second solution, remember to check the num % 10 == 0;



// Regular Solution

// class Solution {
//     public boolean isPalindrome(int num) {
//         // write your code here
//         if (num < 0) {
//             return false;
//         }

//         return num == reverseNum(num);
//     }

//     private int reverseNum(int num) {
//         long reNum = 0L;
//         while (num != 0) {
//             reNum = 10 * reNum + num % 10;
//             num /= 10;
//         }
//         if (reNum > Integer.MAX_VALUE || reNum < Integer.MIN_VALUE) {
//             return 0;
//         }

//         return (int)reNum;
//     }
// }

class Solution {
    public boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int halfRev = 0;
        while (num > halfRev) {
            halfRev = 10 * halfRev + num % 10;
            num /= 10;
        }
        return halfRev == num || halfRev / 10 == num;
    }
    
}
