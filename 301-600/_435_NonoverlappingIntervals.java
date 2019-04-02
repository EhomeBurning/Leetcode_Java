package leetcode_301To600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _435_NonoverlappingIntervals {
    /**
     * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

     Note:
     You may assume the interval's end point is always bigger than its start point.
     Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
     Example 1:
     Input: [ [1,2], [2,3], [3,4], [1,3] ]

     Output: 1

     Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
     Example 2:
     Input: [ [1,2], [1,2], [1,2] ]

     Output: 2

     Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     Example 3:
     Input: [ [1,2], [2,3] ]

     Output: 0

     Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

     [ [1,2], [2,3], [3,4], [1,3] ]


     time : O(nlogn)
     space : O(1)

     * @param intervals
     * @return
     */

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    public int eraseOverlapIntervals2(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;
                return o2.start - o1.start;
            }
        });
        int end = Integer.MIN_VALUE;
        int res = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                end = interval.end;
            } else {
                res++;
            }
        }
        return res;
    }
}
