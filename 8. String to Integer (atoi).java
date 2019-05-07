// * Tag: String;    
// > Solution:     
// > 1. firstChar as a sign;       
// > 2. see if the following char is digit or not;       
// > 3. if char, result = 10 * result + curNum;   
// * Time: O(n);    
// * Space: O(1);    
// * Tips:      
// 1. mind MAX_VALUE and MIN_VALUE;   




class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        char firstChar = str.charAt(0);
        int startIndex = 0;
        long resultLong = 0;
        
        if (firstChar == '+') {
            sign = 1;
            startIndex = 1;
        } else if (firstChar == '-') {
            sign = -1;
            startIndex = 1;
        }
        
        for (int i = startIndex; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                return sign * (int)resultLong;
            }
            
            int curNum = ch - '0';
            resultLong = 10 * resultLong + curNum;
            
            if (sign == 1 && resultLong > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            
            if (sign == -1 && resultLong > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        
        }
        return sign * (int)resultLong;
        
    }
}