package middle_level;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 *
 * @author mango
 * @create 2019-03-20 2:34 PM
 */
public class MinMeetingRooms {
    /**
     * 对起始时间进行排序，使用最小堆来记录当前会议的结束时间，
     * 当心会议的起始时间大于最小堆中的最早结束时间，说明新会议与堆中的最早结束会议不重叠。
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        //将intervals按照开始时间排序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int rooms = 0;
        int active = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= intervals[i].start) {
                active--;
                heap.poll();
            }
            active++;
            heap.offer(intervals[i].end);
            rooms = Math.max(rooms, active);
        }
        return rooms;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}