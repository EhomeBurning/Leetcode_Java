// Solution: 倒着加(用index递减的方式)，然后用一个carry保存着进位, 用||就行

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int sum = carry;
            if (len1 >= 0) {
                sum += a.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                sum += b.charAt(len2--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}