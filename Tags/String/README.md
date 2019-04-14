# String 
*There are five topics about String*

## 1. Removal 
### 1.1 remove some particular chars from a string.
### 1.2 remove all leading/tralling/duplicated empty spaces from a string

## 2. Deduplicate


## 3. Substring -> strstr



## 4. String Reversal  

### 4.1 basic reverse   
#### [344. Reverse String](https://leetcode.com/problems/reverse-string/)    
Example 1:
Input: ["h","e","l","l","o"]   
Output: ["o","l","l","e","h"]   
Method 1:   Iteration(two pointers different direction). Swap left and right pointers.        
Time: O(n);    
Space: O(1);   

Method 2: Recursive.   
1. base case: 0 or 1 char remaining.  i >= j.     
2. recursive rule: reverse(i + 1, j - 1).      

 
### 4.2 Double shift -> "I love Google" trick
#### 4.2.1 Right shift 
Example question: reverse words in sentence    
[186. Reverse Words in a String II](https://leetcode.com/problems/reverse-words-in-a-string-ii/)   
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]  
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]  

[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)     
*Handle the Spaces - head, trailing, between*  
Example 1:    
Input: "the sky is blue"  
Output: "blue is sky the"  
Method1: Stack  
Method2:   
Step1. Reverse each word    
Step2. Reverse the sentence   







## 5. Replacement
