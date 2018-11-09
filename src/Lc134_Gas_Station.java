public class Lc134_Gas_Station {

/**
 * Tag: Array
 * Time: O(n)
 * Space: O(1)
 * Note: total指全部的，sum仅指部分大于零的差值，只要sum小于零，就将其归零，并记下index位置
 */



    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length ==0 || cost == null || cost.length == 0) {
            return -1;
        }

        int sum = 0, total = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total < 0 ? -1 : index + 1;

    }
}