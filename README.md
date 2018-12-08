# Leetcode_Java
*Solutions of LeetCode Algorithm Problems with Java.*

### 463. Island Perimeter <br>
Solution: <br> loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1. <br> <br>
Tips: <br> 
1. Each surrounded zero should be in the matrix range. <br>
2. For those not in the range, still add perimeter one. <br>
