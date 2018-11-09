public class Lc151_Reverse_Words_in_a_String {

/**
 * Tag: String
 * Time:
 * Space:
 * Note: StringBuilder记得要转成String类型才能返回，正则表达式要记一下，空格记得要trim（）
 *       这次写一个StringBuilder的方法，还有一种常规的reverse做法，下一遍的时候写
 */

    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}