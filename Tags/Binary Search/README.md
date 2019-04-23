# Binary Search 
*Make the size of problem smaller every time and Time = O(logn)*

## Topics
* [1. Classic Binary Search Problems](#1-classic-bianry-search-problems)  
* [2. Others](#2-others)

## 1. Classic Binary Search Problems
*Find target in sorted Array*  

* [704. Binary Search (Easy)](https://leetcode.com/problems/binary-search/)  
> Input: nums = [-1,0,3,5,9,12], target = 9   
> Output: 4   
> Explanation: 9 exists in nums and its index is 4    

* [702. Search in a Sorted Array of Unknown Size (Medium)](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/) 
> Input: array = [-1,0,3,5,9,12], target = 9  
> Output: 4  
> Explanation: 9 exists in nums and its index is 4  
> Solution:   
> 1. Step 1: Keep jumping 2 ^ i times until jump out of boundry;  
> 2. Step 2: Binary Search in [2 ^ (i - 1), 2 ^ i];   
> Time: O(log_2(n)); Let n = 2 ^ i;  
  
  
> Follow up: Ten times every time?   

Action | Two Times | Ten Times  
------------ | ------------ | -------------  
Jump out | log_2(n) | log_10(n)   
Jump in | log_2(2n) |  log_2(10n)  
> n denotes the number of contents that should be searched. 
> diff = Two Times - Ten Times = log_2(n) + log_10(n) - log_2(2n) - log_2(10n)  < 0  -> Two Times Better!  
> n -> infinate, diff = 0 ->  equal; diff > 0 -> Ten better; diff < 0 -> Two better;  


* [74. Search a 2D Matrix(Medium)](https://leetcode.com/problems/search-a-2d-matrix/)   
> Input: matrix = [[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]    
> target = 3  
> Output: true  
> Solution: midRow = mid / col; midCol = mid % col;  


## 2. left + 1 < right  

* [ClosestToTarget](https://github.com/EhomeBurning/Leetcode_Java/blob/master/Tags/Binary%20Search/ClosestInSortedArray.java)
> input: A = {1, 2, 3}, T = 2; output: 1   
> input: A = {1, 4, 6}, T = 3, output: 1   

* [FirstOccurrence](https://github.com/EhomeBurning/Leetcode_Java/blob/master/Tags/Binary%20Search/FirstOccurrence.java)
```
if (array[mid] == target) right = mid;
if (array[left] == target) return left; 
```

* [LastOccurrence](https://github.com/EhomeBurning/Leetcode_Java/blob/master/Tags/Binary%20Search/LastOccurrence.java)
```
if (array[mid] == target) left = mid;
if (array[right] == target) return right; 
```

* [658. Find K Closest Elements(Medium)](https://leetcode.com/problems/find-k-closest-elements/)
> Input: [1,2,3,4,5], k=4, x=3  
> Output: [1,2,3,4]  
> Solution:   
> 1. Step1: Find the left and right range of target;  
> 2. Step2: Middle out. 中心开花， 谁近移谁;   


* [278. First Bad Version(Easy)](https://leetcode.com/problems/first-bad-version/)  
> Given n = 5, and version = 4 is the first bad version.  
> call isBadVersion(3) -> false
> call isBadVersion(5) -> true
> call isBadVersion(4) -> true
> Then 4 is the first bad version.  
> Solution: FirstOccurrence; 1. if (nums[mid] == target) right = mid;  2. 先看leftf符不符合      

## 3. Which Half

* [540. Single Element in a Sorted Array(Medium)](https://leetcode.com/problems/single-element-in-a-sorted-array/)    
> Input: [1,1,2,3,3,4,4,8,8]  
> Output: 2  
> Solution: mid odd or even;   

* [33. Search in Rotated Sorted Array(Medium)](https://leetcode.com/problems/search-in-rotated-sorted-array/)  
> Solution:   
> 1. Step 1. classic binary search, get the mid;  
> 2. Step 2. num[left] and nums[mid]  
> 2.1 case 1: num[left] <= nums[mid]; num[left] <= target < nums[mid], right = mid - 1;    
> 2.2 case 2: nums[mid] <= nums[right]; nums[mid] < target <= nums[right], left = mid + 1;   


## 3. Half Value  
* [374. Guess Number Higher or Lower(easy)](https://leetcode.com/problems/guess-number-higher-or-lower/)
> Input: n = 10, pick = 6  
> Output: 6  


* [378. Kth Smallest Element in a Sorted Matrix(Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
Left pointer matters. 
> Solution:   
> 1. Step 1: get the midVal(half of minVal and maxVal);   
> 2. Step 2: count how many numbers bigger than midVal;   
> 3. Step 3: change min or max depends on relationship between k and midVal;  
> Time: O(nlog(max - min));  
> Space: O(1);  


## 3. Others

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












