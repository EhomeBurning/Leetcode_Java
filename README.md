# Leetcode_Java
*Solutions of LeetCode Algorithm Problems with Java.*

## 7. Reverse Integer<br>
Solution:<br>
while (x > 0)<br>
123 % 10 = 3;<br>
result = 10 * result + 3;<br>
x = x / 10;<br>

tips:<br>
check the OVERFLOW after reversing, so the result should be long type;<br>
negative number case;<br>



## 463. Island Perimeter <br>
Solution: <br> loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1. <br> <br>
Tips: <br> 
1. Each surrounded zero should be in the matrix range. <br>
2. For those not in the range, still add perimeter one. <br>
