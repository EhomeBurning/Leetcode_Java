public class Lc13_Roman_To_Integer {
    public int romanToInt(String s) {
        // 右边大于左边，则右 - 左
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = toNumber(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))){
                ans += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else{
                ans += toNumber(s.charAt(i));
            }
        }
        return ans;
    }

    public static int toNumber(char c) {
        int ans = 0;
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return ans;
    }
}