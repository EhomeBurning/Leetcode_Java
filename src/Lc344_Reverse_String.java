public class Lc344_Reverse_String {
    public String reverseString(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        char[] str = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = str[right];
            str[right--] = str[left];
            str[left++] = temp;
        }

        return new String(str);


    }



}