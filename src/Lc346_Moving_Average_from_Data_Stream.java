import java.util.Queue;
import java.util.LinkedList;
/**
 * Tag: Queue, design
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Lc346_Moving_Average_from_Data_Stream {
    private int size;
    private Queue<Integer> que;
    private double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        que = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        if (que.size() == size) {
            sum = sum - que.poll();
        }

        que.offer(val);
        return sum / que.size();

    }
}