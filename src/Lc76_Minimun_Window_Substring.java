// time: O(n)
// space: O(n)



class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = constructDict(t);
        
        int slow = 0, matchCount = 0, minLen = Integer.MAX_VALUE, index = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            Character ch = s.charAt(fast);
            Integer rightNeed2Appear = map.get(ch);
            if (rightNeed2Appear == null) {
                continue;
            }
            map.put(ch, rightNeed2Appear - 1);
            if (rightNeed2Appear == 1) {
                // 1 --> 0
                matchCount++;
            }
            while (matchCount == map.size()) {
                // valid window
                int windowLen = fast - slow + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    index = slow;
                }
                // push left 
                char leftMost = s.charAt(slow++);
                Integer leftNeedToAppear = map.get(leftMost);
                if (leftNeedToAppear == null) {
                    continue;
                }
                map.put(leftMost, leftNeedToAppear + 1);
                if (leftNeedToAppear == 0) {
                    // 0 --> 1
                    matchCount--; // 下次会退出while，继续在for里面更改fast位置
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
        
    }
    
    private Map<Character, Integer> constructDict(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            Integer needToAppear = map.get(ch);
            if (needToAppear == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, needToAppear + 1);
            }
        }
        return map;
    }
}