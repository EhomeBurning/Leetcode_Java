第1题， two pass.
用两个变量， int left, int right.
从头扫第1遍的时候， 加进去所有left,如果right不大于left, 就加进去stringbuilder。这样保证“)”都有相对应的"("。
第2遍，从第1次的stringbuilder的末尾扫，加进去所有 )， 如果left 不大于 right, 加进去所有 (
第2遍pass的时候，解决了第1pass, “（”比 “）“多的情况。
“((( )” → “()”
“( )))” → “()”
“”

    // fb高频面经：只返回一个结果
    // solution：2 scan； 从前往后，rightCount < leftCount; 从后往前， leftCount < rightCount; 
    // "((()" -> "()" leftCount > rightCount
    // “)(” -> "" 
    
    
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int leftCount = 0, rightCount = 0;
            String firstScan = "";
            for (Character ch : s.toCharArray()) {
                if (ch == '(') {
                    firstScan += ch;
                    leftCount++;
                } else if (ch == ')' && rightCount < leftCount) {
                    firstScan += ch;
                    rightCount++;
                } else if (ch != '(' && ch != ')') {
                    firstScan += ch;
                }
            }
            leftCount = 0;
            rightCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = firstScan.length() - 1; i >= 0; i--) {
                Character ch = firstScan.charAt(i);
                if (ch == ')') {
                    sb.append(ch);
                    rightCount++;
                } else if (ch == '(' && leftCount < rightCount) {
                    sb.append(ch);
                    leftCount++;
                } else if (ch != '(' && ch != ')') {
                    sb.append(ch);
                }
            }
            List<String> result = new ArrayList();
            result.add(sb.reverse().toString());
            return result;
        }
    }

写一个短一点并且好理解的解法：
1.从左到右遍历String获得左括号和右括号的计数
2.从左到右遍历String，如果碰到左括号或右括号，就删除左括号或右括号，更新计数，然后把剩下的String放入DFS递归，注意当有连续的左括号或者右括号的时候，必须先删前面的
3.DFS退出的条件是左括号和有括号的计数均为0
时间复杂度就是O (2^(l + r))
spcae: O(l + r) ^ 2 ~ O(n) ^ 2
l left should be removed, r right should be removed 

    public class Solution {
     
        public List<String> removeInvalidParentheses(String s) {
            
            List<String> results = new ArrayList<String>();       
            int[] result = getLeftRightCount(s);
            dfs(s, 0, result[0], result[1], results);
            
            return results;
        }
        
        private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
            if(leftCount == 0 && rightCount == 0 && isStringValid(s)) {
                results.add(s);
                return;
            }
            
            for(int i = startIndex; i < s.length(); i++) {
                if(i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }
                
                if(leftCount > 0 && s.charAt(i) == '(') {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
                }
                
                if(rightCount > 0 && s.charAt(i) == ')') {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
                }
            }
        }
        
        private boolean isStringValid(String s) {
            int[] result = getLeftRightCount(s);
            return result[0] == 0 && result[1] == 0;
        }
        
        private int[] getLeftRightCount(String s) {
            int[] count = new int[]{0, 0};
            for(char c : s.toCharArray()) {
                if(c == '(') {
                    count[0]++;
                }    
                if(c == ')') {
                    if(count[0] > 0) {
                        count[0]--;
                    } else {
                        count[1]++;
                    }
                }
            }
            return count;
        }
    }
