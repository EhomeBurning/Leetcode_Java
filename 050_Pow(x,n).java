// *Example*:<br> 2^10 -> 2^5 -> 2^2 -> 2^1 -> 2^0 <br>
<<<<<<< HEAD
//
// *Solution*: <br> Recursion. <br>
// 1. basic case: n = 0, x ^ n = 1; <br>
// 2. recursive rule: n odd, x * x^(n/2) * x^(n/2); n even, x^(n/2) * x^(n/2); <br>
//
// *Tips*: <br>
// 1. negative <br>
// eg: 2^-4 = 1 / 2^4; -> n = -n, x = 1 / x; <br><br>
//
=======

// *Solution*: <br> Recursion. <br>
// 1. basic case: n = 0, x ^ n = 1; <br>
// 2. recursive rule: n odd, x * x^(n/2) * x^(n/2); n even, x^(n/2) * x^(n/2); <br>

// *Tips*: <br>
// 1. negative <br>
// eg: 2^-4 = 1 / 2^4; -> n = -n, x = 1 / x; <br><br>

>>>>>>> 0c1be95806921d21fe7b7c8ca33cce84d684a0cc
// *Time*: O(logx) // level of recursion tree <br>
// *Space*: O(logx) // how many call_Stack <br>


class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0.0;
        }
        if (n < 0) {
            return 1/x * myPow(1/x, -(n + 1));
        }
        
        double halfPow = myPow(x, n / 2);
        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 0c1be95806921d21fe7b7c8ca33cce84d684a0cc
