# Leetcode_Java
*Solutions of LeetCode Algorithm Problems with Java.*

## 7. Reverse Integer<br>
*Solution*:<br>
while (x > 0)<br>
123 % 10 = 3;<br>
result = 10 * result + 3;<br>
x = x / 10;<br>

*tips*:<br>
check the OVERFLOW after reversing, so the result should be long type;<br>
negative number case;<br>



## 9. Palindrome Number <br>
*Solution*: <br>
Despite the regular "reverse integer" solution, there is one brilliant solution without considering the overflow. <br>
Reverse half the integer; <br>
condition: halfRev == num || halfRev / 10 = num; <br>
tips: <br>
for the second solution, remember to check the case : num != 0 && num % 10 == 0;


## 50. Pow(x, n) <br>
*Example*:<br> 2^10 -> 2^5 -> 2^2 -> 2^1 -> 2^0 <br>

*Solution*: <br> Recursion. <br>
1. basic case: n = 0, x ^ n = 1; <br>
2. recursive rule: n odd, x * x^(n/2) * x^(n/2); n even, x^(n/2) * x^(n/2); <br>

*Tips*: <br>
1. negative <br>
eg: 2^-4 = 1 / 2^4; -> n = -n, x = 1 / x; <br><br>

*Time*: O(logx) // level of recursion tree <br>
*Space*: O(logx) // how many call_Stack <br>



## 412. Fizz Buzz<br>
one more counter solution. ++ before if condition ; <br>


## 463. Island Perimeter <br>
*Solution*: <br>
loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1. <br> <br>
*Tips*: <br>
1. Each surrounded zero should be in the matrix range. <br>
2. For those not in the range, still add perimeter one. <br>
