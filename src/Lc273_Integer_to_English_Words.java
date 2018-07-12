public class Lc273_Integer_to_English_Words {

/**
 * Tag: String
 * Time: O(n)
 * Space: O(n)
 * Solution: 每三位一个循环
 */

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",                                                 "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",                                                    "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String res = "";
        int count = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + THOUSANDS[count] + " " + res;
            }
            num /= 1000;
            count++;
        }
        return res.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10); //  每次都要调用helper，而不是直接从list里面找
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}