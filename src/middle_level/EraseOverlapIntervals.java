package middle_level;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 《玩转算法面试视频例题》贪心算法 和 动态规划（最长上升子序列）
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 9:06 下午
 */
public class EraseOverlapIntervals {
    /**
     * 最长上升子序列
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照start升序排列，start相同按照end升序排列
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        // dp[i] 表示的是[0,i]不产生重叠的区间的最大个数
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                // 前一个的end小于等于当前的start，说明不会产生重叠，+1
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return intervals.length - res;
    }

    /**
     * 贪心算法
     * 按照区间的结尾排序
     * 每次选择结尾最早的，且和前一个区间不重叠的区间
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals_greedy(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照区间的结尾排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1])));

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是x
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
