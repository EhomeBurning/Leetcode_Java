import java.util.HashMap;

public class Lc359_Logger_Rate_Limiter {
    /**
     * Tag: Hash Table, Design
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    /** Initialize your data structure here. */
    public Logger() {
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */

    HashMap<String, Integer> map = new HashMap();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < map.getOrDefault(message, 0)) {
            return false;
        }

        map.put(message, timestamp + 10);
        return true;
    }
}
