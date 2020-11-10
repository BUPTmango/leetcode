package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间问题
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例?2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/16 11:53 上午
 */
public class Merge {
    /**
     * 左、右区间分成两个数组分别排序
     * 逐个判断是否可合并
     * 若可合并则合入后者
     * 此处不急于合并（j 在等待另一半），而是等待可成对后，再合入 list
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                // 下一个 start 左区间已无法涵盖当前 end 右区间
                // 已找到 j 的另一半 i
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 按照起点排序 之后进行合并
     * @param intervals
     * @return
     */
    public int[][] merge_another(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 按照每个区间的起点排序c
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else {
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
