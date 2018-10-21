/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// time : O(nlogn)
// sapce: O(n)
    
    
    
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) {
            return -1;
        }
        int len = intervals.length;
        int[] startList = new int[len];
        int[] endList = new int[len];
        
        for (int i = 0; i < len; i++) {
            startList[i] = intervals[i].start;
            endList[i] = intervals[i].end;
        }
        Arrays.sort(startList);
        Arrays.sort(endList);
        
        int roomCount = 0;
        int endPointer = 0;
        for (int startPointer = 0; startPointer < len; startPointer++) {
            if (startList[startPointer] < endList[endPointer]) {
                roomCount++;
            } else {
                endPointer++;
            }
        }
        return roomCount;
    }
}