# Binary Search 
*Make the size of problem smaller every time and Time = O(logn) *

## Topics
* [1. Classic Binary Search Problems](#1-classic-bianry-search-problems)  
* [2. Others](#2-others)

## 1. Classic Binary Search Problems

* [704. Binary Search (Easy)](https://leetcode.com/problems/binary-search/)  
> Input: nums = [-1,0,3,5,9,12], target = 9   
> Output: 4   
> Explanation: 9 exists in nums and its index is 4    

* [702. Search in a Sorted Array of Unknown Size (Medium)](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/) 
> Input: array = [-1,0,3,5,9,12], target = 9  
> Output: 4  
> Explanation: 9 exists in nums and its index is 4  
> Solution: Double index each time to find range;  

* [540. Single Element in a Sorted Array(Medium)](https://leetcode.com/problems/single-element-in-a-sorted-array/)   
> Input: [1,1,2,3,3,4,4,8,8]  
> Output: 2  
> Solution: mid odd or even;  

* [74. Search a 2D Matrix(Medium)](https://leetcode.com/problems/search-a-2d-matrix/)   
> Input: matrix = [[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]    
> target = 3  
> Output: true  
> Solution: midRow = mid / col; midCol = mid % col;  


## 2. left + 1 < right  


* [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)  
> Given n = 5, and version = 4 is the first bad version.  
> call isBadVersion(3) -> false
> call isBadVersion(5) -> true
> call isBadVersion(4) -> true
> Then 4 is the first bad version.  
> Solution: First true; if (nums[mid] == target) right = mid;     



## 2. Others

* [240. Search a 2D Matrix II(Medium)](https://leetcode.com/problems/search-a-2d-matrix-ii/)  
> input: [
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]  
> Given target = 5, return true.  
> Given target = 20, return false.  
> Solution: either start with top right or bottom left; x++, y-- to locate target;  










