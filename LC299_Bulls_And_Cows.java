public class LC299_Bulls_And_Cows {

/**
 * Tag: Hash Table, Array
 * Time: O(n)
 * Space: O(1)
 * Note: 存储一个 0 - 9 的array，每个secret都会加一，每个guess都会减一，不等于零的即为cow
 * 注意：在判断是否大于或小于零时，因为要填平，所以是反方向的
 */


    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int sec = secret.charAt(i);
            int gue = guess.charAt(i);
            if (sec == gue) {
                bull++;
            } else {
                if (count[sec - '0']++ < 0) {
                    cow++;
                }
                if (count[gue - '0']-- > 0) {
                    cow++;
                }
            }

        }
        return bull + "A" + cow + "B";

    }
}