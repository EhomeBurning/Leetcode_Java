class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        
        for (int left = 0, right = s.length - 1;
             left < right; left++, right --) {
            swap(s, left, right);
        }
    }
    
    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
