public class Lc165_Compare_Version_Numbers {

/**
 * Tag: String, Math
 * Time: O(n)
 * Space: O(n)
 * Solution: 先把version分成数字, 比较各个数字的大小, 少的部分自动补成0；
 * Note: String.split("\\.") 12个特殊的字符需要\\或者[]分割开；
 Integer.parseInt(String，num) 将string转成int型，num为转成的进制；Double.parseInt(String)；
 */
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        for (int i = 0; i < Math.max(version1.length(), version2.length()); i++) {
            int num1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;  // 注意这里是ver1而不是version1
            int num2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}