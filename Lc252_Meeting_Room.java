import java.util.Arrays;

public class Lc252_Meeting_Room {
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/**
 * Tag:Sort
 * Time: O(nlogn)
 * Space: O(1)
 */

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, (x,y) -> x.start - y.start);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}